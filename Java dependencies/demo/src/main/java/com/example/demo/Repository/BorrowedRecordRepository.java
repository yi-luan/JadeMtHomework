package com.example.demo.Repository;
import com.example.demo.Domain.BookModel;
import com.example.demo.Domain.BorrowRecordModel;
import com.example.demo.Domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedRecordRepository extends JpaRepository<BorrowRecordModel, Long> {
    BorrowRecordModel findByUserAndBook(UserModel user, BookModel book);
    // 可以根據需要添加其他自訂的查詢方法
}