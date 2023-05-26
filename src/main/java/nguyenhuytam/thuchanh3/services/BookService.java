package nguyenhuytam.thuchanh3.services;

import com.sun.source.tree.LambdaExpressionTree;
import nguyenhuytam.thuchanh3.entity.Book;
import nguyenhuytam.thuchanh3.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public  void addBook(Book book){
        bookRepository.save(book);

    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public void uppdateBook(Book book){
        bookRepository.save(book);
    }
}
