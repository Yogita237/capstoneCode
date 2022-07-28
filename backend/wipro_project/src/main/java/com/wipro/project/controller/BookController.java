package com.wipro.project.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.wipro.project.models.Book;
import com.wipro.project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("book")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BookController {
    @Autowired
    private BookService bs;



    @PostMapping
    public Book addBook1(@RequestParam("names") String name, @RequestParam("price")Float price, @RequestParam("author")String author, @RequestParam("genre")String genre, @RequestParam("category")String category, @RequestParam("picture")MultipartFile file) throws IOException
    {
        byte [] picture=file.getBytes();
        Book book=new Book( name, price, author,genre,category,picture);
        return bs.create(book);
    }

    @GetMapping
    public List<Book> getAllBook()
    {
        return bs.read();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable("id") Integer id)
    {
        return bs.read(id);
    }
    //for fetching category

    @PutMapping
    public Book updateBook(@RequestBody Book book)
    {
        return bs.update(book);
    }

    @DeleteMapping
    public Book deleteBook(@PathVariable("id")Integer id)
    {
        return bs.delete(id);
    }



    @GetMapping("/category/{category}")
    public List<Book> findByCategory(@PathVariable("category") String category)
    {
        return bs.findBooksByCategory(category);
    }



}

