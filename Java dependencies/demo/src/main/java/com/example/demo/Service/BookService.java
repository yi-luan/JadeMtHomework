package com.example.demo.Service;

import com.example.demo.Domain.BookModel;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookModel borrowBook(String title) {
        BookModel book = bookRepository.findByTitle(title);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        if (!book.getBookBorrowStatus().toString().equals("OCCUPIED")) {
            throw new RuntimeException("Book is not available for borrowing");
        }

        book.setBookBorrowStatus(BookModel.BorrowedStatus.OCCUPIED);
        return bookRepository.save(book);
    }

    public BookModel returnBook(String title) {
        BookModel book = bookRepository.findByTitle(title);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        if (book.getBookBorrowStatus().toString().equals("OCCUPIED")) {
            throw new RuntimeException("Book is not borrowed");
        }

        book.setBookBorrowStatus(BookModel.BorrowedStatus.NOTOCCUPPIED);
        return bookRepository.save(book);
    }
}