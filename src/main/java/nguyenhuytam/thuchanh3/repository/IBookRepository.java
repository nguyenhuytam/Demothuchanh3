package nguyenhuytam.thuchanh3.repository;

import nguyenhuytam.thuchanh3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
