package web.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web.entity.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
//    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
//    List<Product> findByPrice(double minPrice, double maxPrice);
    List<Product> findByPriceBetween(double minPrice, double maxPrice); //Bài 4

//    @Query("FROM Product o WHERE o.name LIKE ?1")
//    Page<Product> findByKeywords(String keywords, Pageable pageable);
Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("""
           SELECT o.category AS group,
                  SUM(o.price) AS sum,
                  COUNT(o)     AS count
             FROM Product o
            GROUP BY o.category
            ORDER BY SUM(o.price) DESC
           """)
    List<Report> getInventoryByCategory();
}
