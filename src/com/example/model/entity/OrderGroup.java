package com.example.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderGroup {

    private Long id;

    private String status;

    private String orderType;   // 주문의 형태 - 일괄 / 개별

    private String revAddress;

    private String revName;

    private String paymentType; // 카드 / 현금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // OrderGroup N : 1 User
    private User user;

    // OrderGroup 1 : N OrderDetail
    private List<OrderDetail> orderDetailList;

}
