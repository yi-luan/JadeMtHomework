package com.example.demo.DTO;

public class UserDto {

    public UserDto(Character Id,String PhoneNumber){
        this.id = Id;
        this.Cellphone = PhoneNumber;
    }
    private Character id;

    private String UserName;

    private  String Cellphone;

    public String getUserName() {
        return UserName;
    }

    public String getUserPhoneNumber() {
        return  this.Cellphone;
    }

    public void setUserName(String name) {
        this.UserName = name;
    }

}
