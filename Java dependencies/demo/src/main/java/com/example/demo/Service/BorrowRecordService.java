package com.example.demo.Service;

import com.example.demo.Domain.BookModel;
import com.example.demo.Domain.BorrowRecordModel;
import com.example.demo.Domain.UserModel;
import com.example.demo.Repository.BorrowedRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BorrowRecordService {
    private final BorrowedRecordRepository borrowRecordRepository;

    @Autowired
    public BorrowRecordService(BorrowedRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public BorrowRecordModel createBorrowRecord(UserModel user, BookModel book) {
        BorrowRecordModel borrowRecord = new BorrowRecordModel(user,book);
        borrowRecord.setBorrowTime(LocalDateTime.now());
        return borrowRecordRepository.save(borrowRecord);
    }

    public BorrowRecordModel updateReturnTime(BorrowRecordModel borrowRecord) {
        borrowRecord.setReturnTime(LocalDateTime.now());
        return borrowRecordRepository.save(borrowRecord);
    }
}