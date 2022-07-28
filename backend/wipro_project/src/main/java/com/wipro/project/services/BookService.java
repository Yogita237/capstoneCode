package com.wipro.project.services;

import java.util.List;
import java.util.Optional;

import com.wipro.project.models.Book;
import com.wipro.project.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {
    @Autowired
    private BookRepo br;

    public Book create(Book book) {
        return br.save(book);
    }
    public List<Book> read() {
        return (List<Book>) br.findAll();
    }
    public Book read(Integer id) {
        Optional<Book> temp = br.findById(id);
        Book b=null;
        if(temp.isPresent())
        {
            b=temp.get();
        }
        return b;
    }

    public Book update(Book book) {
        Book b=read(book.getId());
        if(b!=null)
        {
            br.save(book);
        }
        return b;
    }
    public Book delete(Integer id) {
        Book b=read(id);
        if(b!=null)
        {
            br.delete(b);
        }
        return b;
    }


    public List<Book> findBooksByCategory(String category)
    {
        return br.findByCategory(category);
    }



}

