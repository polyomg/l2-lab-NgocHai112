package web.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data // ✅ tự sinh getter/setter
public class MailForm {

    private String from;
    private String to;          // người nhận chính (bắt buộc)
    private String cc;          // cc (tùy chọn, có thể để rỗng)
    private String bcc;         // bcc (tùy chọn, có thể để rỗng)
    private String subject;     // tiêu đề
    private String body;        // nội dung (HTML ok)
    private MultipartFile[] attachments; // nhiều file đính kèm
}
