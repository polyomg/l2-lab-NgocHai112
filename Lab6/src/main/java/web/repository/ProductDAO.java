package web.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.Product;

public interface ProductDAO extends JpaRepository<Product,Integer> {

}
