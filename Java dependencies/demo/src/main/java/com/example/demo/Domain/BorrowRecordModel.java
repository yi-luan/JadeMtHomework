package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class BorrowRecordModel {


    public BorrowRecordModel(UserModel user,BookModel book){
        this.user = user;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserModel user;

    @OneToOne
    private BookModel book;

    private LocalDateTime borrowTime;
    private LocalDateTime returnTime;

    public void setUser(UserModel user) {
        this.user = user;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public void setBorrowTime(LocalDateTime now) {
        this.borrowTime = now;
    }

    public void setReturnTime(LocalDateTime now) {
        this.returnTime = now;
    }

    public void setReturnDate(LocalDateTime now) {
        this.returnTime = now;
    }

    // getters and setters

    // constructors
}