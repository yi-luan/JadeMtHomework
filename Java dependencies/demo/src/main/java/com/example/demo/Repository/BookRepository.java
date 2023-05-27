package com.example.demo.Repository;
import com.example.demo.Domain.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, String> {
    BookModel findByTitle(String title);
}