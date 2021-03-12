package com.example.model.network.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.model.entity.Item;
import com.example.model.entity.OrderGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailApiRequest {

    private Long id;

    private String status;

    private String arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private String createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // OrderDetail N : 1 Item
    private int itemId;

    // OrderDetail N : 1 OrderGroup
    private int orderGroupId;
    
}
