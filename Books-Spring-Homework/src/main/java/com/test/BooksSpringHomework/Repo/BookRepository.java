package com.test.BooksSpringHomework.Repo;

import com.test.BooksSpringHomework.Models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
