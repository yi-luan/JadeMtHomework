package com.example.demo.Domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookModel {

    public enum BorrowedStatus{
        OCCUPIED,
        NOTOCCUPPIED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Character id;

    /**
     *  書名
     */
    private String title;

    /**
     *  作者
     */
    private String author;

    /**
     *  狀態 ('Occupied','notOccupied')
     */
    private BorrowedStatus status;

    public BorrowedStatus getBookBorrowStatus() {
        return this.status;
    }

    public void setBookBorrowStatus(BorrowedStatus status) {
        this.status = status;
    }

    // getters and setters

    // constructors
}