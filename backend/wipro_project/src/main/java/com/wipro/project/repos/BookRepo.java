package com.wipro.project.repos;
import com.wipro.project.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepo extends CrudRepository<Book,Integer> {

    List<Book> findByCategory(String category);

}
