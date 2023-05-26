package nguyenhuytam.thuchanh3.controller;

import jakarta.validation.Valid;
import nguyenhuytam.thuchanh3.entity.Book;
import nguyenhuytam.thuchanh3.entity.Category;
import nguyenhuytam.thuchanh3.services.BookService;
import nguyenhuytam.thuchanh3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllcategory(Model model){
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories",categories);
        return "category/list";
    }
    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String addBook( @ModelAttribute("category") Category category, Model model){
        categoryService.addBook(category);
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        Category category = categoryService.getCategoryID(id);
        categoryService.deleteCategory(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryFrom(@PathVariable("id") Long id, Model model){
        Category category = categoryService.getCategoryID(id);
        if (category != null){
            model.addAttribute("category", category);
            return "category/edit";
        }else{
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/category";

    }
}
