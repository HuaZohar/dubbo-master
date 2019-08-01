package com.learn.gmail.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserAddress implements Serializable {
    private Integer id;
    private String userAddress;
    private Integer userId;

    public UserAddress(Integer id, String userAddress, Integer userId) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", userId=" + userId +
                '}';
    }
}
