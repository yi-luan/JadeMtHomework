package com.example.demo.Service;

import com.example.demo.Domain.BookModel;
import com.example.demo.Domain.BorrowRecordModel;
import com.example.demo.Domain.UserModel;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.BorrowedRecordRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    private final BorrowedRecordRepository borrowedRecordRepository;


    @Autowired
    public UserService(
            UserRepository userRepository,
            BookRepository bookRepository,
            BorrowedRecordRepository borrowedRecordRepository
    ) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.borrowedRecordRepository = borrowedRecordRepository;
    }

    public UserModel createUser(String name) {
        UserModel user = new UserModel();
        user.setUserName(name);
        return userRepository.save(user);
    }

    public UserModel registerUser(String phoneNumber) {
        UserModel existingUser = userRepository.findByPhoneNumber(phoneNumber);
        if (existingUser != null) {
            throw new RuntimeException("User with phone number already exists");
        }

        UserModel newUser = new UserModel();
        newUser.setUserPhoneNumber(phoneNumber);
        return userRepository.save(newUser);
    }

    public UserModel getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean borrowBook(Character userId, String bookId) {
        UserModel user = this.userRepository.findById(userId).orElse(null);
        BookModel book = this.bookRepository.findById(bookId).orElse(null);

        if(user == null || book == null) return false;
        if(book.getBookBorrowStatus() == BookModel.BorrowedStatus.OCCUPIED) return false;

        book.setBookBorrowStatus(BookModel.BorrowedStatus.OCCUPIED);
        bookRepository.save(book);

        BorrowRecordModel borrowRecord = new BorrowRecordModel(user, book);
        borrowedRecordRepository.save(borrowRecord);

        return true;
    }

    public boolean returnBook(Character userId, String bookId) {
        try{
            UserModel user = this.userRepository.findById(userId).orElse(null);
            BookModel book = this.bookRepository.findById(bookId).orElse(null);

            if(user == null || book == null) return false;


            BorrowRecordModel borrowRecord = borrowedRecordRepository.findByUserAndBook(user, book);
            if (borrowRecord == null) return false;
            borrowRecord.setReturnDate(LocalDateTime.now());
            borrowedRecordRepository.save(borrowRecord);

            book.setBookBorrowStatus(BookModel.BorrowedStatus.NOTOCCUPPIED);
            bookRepository.save(book);
            return true;

        }catch (Exception ex){
            System.out.print(ex.getMessage());
            return false;
        }
    }
}

