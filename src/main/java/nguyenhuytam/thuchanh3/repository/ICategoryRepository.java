package nguyenhuytam.thuchanh3.repository;

import nguyenhuytam.thuchanh3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
