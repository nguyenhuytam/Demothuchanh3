package nguyenhuytam.thuchanh3.services;

import nguyenhuytam.thuchanh3.entity.Book;
import nguyenhuytam.thuchanh3.entity.Category;
import nguyenhuytam.thuchanh3.repository.IBookRepository;
import nguyenhuytam.thuchanh3.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();

    }
    public  void addBook(Category category){
        categoryRepository.save(category);

    }
    public Category getCategoryID(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
