package web.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final List<Mail> queue = new ArrayList<>();

    @Override
    public void send(Mail mail) { // ✅ Gửi mail trực tiếp (dùng lại từ bài 1)
        try {
            MimeMessage message = mailSender.createMimeMessage(); // Tạo mail trống
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            // --- 2.1 Ghi thông tin người gửi ---
            helper.setFrom(mail.getFrom());
            helper.setReplyTo(mail.getFrom());

            // --- 2.2 Ghi thông tin người nhận ---
            helper.setTo(mail.getTo());
            if (!isNullOrEmpty(mail.getCc())) helper.setCc(mail.getCc());
            if (!isNullOrEmpty(mail.getBcc())) helper.setBcc(mail.getBcc());

            // --- 2.3 Tiêu đề & nội dung ---
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true); // true = HTML

            // --- 2.4 Đính kèm file ---
            if (!isNullOrEmpty(mail.getFilename())) {
                for (String fn : mail.getFilename().split("[,;]+")) {
                    File file = new File(fn.trim());
                    helper.addAttachment(file.getName(), file);
                }
            }

            mailSender.send(message); // ✅ Gửi mail thật sự
            System.out.println("✅ Đã gửi mail đến: " + mail.getTo());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void push(Mail mail) { // ✅ Đẩy mail vào hàng đợi (không gửi ngay)
        queue.add(mail);
        System.out.println("📨 Mail đã được xếp hàng đợi: " + mail.getTo());
    }

    // ✅ Chạy nền mỗi 500ms: nếu có mail trong hàng đợi thì gửi
    @Scheduled(fixedDelay = 500)
    public void run() {
        while (!queue.isEmpty()) {
            try {
                Mail mail = queue.remove(0);
                this.send(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
}
