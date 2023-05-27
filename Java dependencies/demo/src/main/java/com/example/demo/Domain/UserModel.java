package com.example.demo.Domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Character id;

    /***
     * 使用者姓名
     */
    private String UserName;

    /***
     * 使用者電話號碼
     */
    private String CellPhone;

    public void setUserName(String name){
        this.UserName = name;
    }

    public void setUserPhoneNumber(String phoneNumber) {
        this.CellPhone = phoneNumber;
    }

    public String getUserPhoneNumber(){
        return this.CellPhone;
    }

    public String getUserName() {
        return  this.UserName;
    }

    public Character getId() {
        return this.id;
    }
}
