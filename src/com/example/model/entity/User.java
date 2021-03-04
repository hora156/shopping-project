package com.example.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Table(name = "user") : 클래스와 스키마 이름이 다를 때
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private int id;

    private String account;

    private String password;

    private String status;      // REGISTERED / UNREGISTERED / WAITING

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private List<OrderGroup> orderGroupList;

}
