package nguyenhuytam.thuchanh3.controller;

import jakarta.validation.Valid;
import nguyenhuytam.thuchanh3.entity.Book;
import nguyenhuytam.thuchanh3.services.BookService;
import nguyenhuytam.thuchanh3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books",books);
        return "book/list";
    }
    @GetMapping("/add")
    public String addBook(Model model){
        model.addAttribute("books",new Book());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("books") Book book, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories",categoryService.getAllCategory());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookFrom(@PathVariable("id") Long id, Model model){
        Book book = bookService.getBookById(id);
        if (book != null){
            model.addAttribute("book", book);
            model.addAttribute("categories",categoryService.getAllCategory());
            return "book/edit";
        }else{
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book book){
        bookService.uppdateBook(book);
        return "redirect:/books";

    }
}
