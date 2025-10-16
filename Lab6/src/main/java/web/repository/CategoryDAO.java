package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {}
