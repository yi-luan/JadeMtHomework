package com.example.demo.Repository;


import com.example.demo.Domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Character> {

    UserModel findByPhoneNumber(String phoneNumber);
}

