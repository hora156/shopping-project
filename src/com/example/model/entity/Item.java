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
public class Item {

    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // 1 : N
    // LAZY = 지연로딩, EAGER = 즉시로딩

    // LAZY = select * from item where id = ?

    // EAGER = 연관관계가 설정된 모든 테이블을 조인한다.(성능저하 유발) 때문에 1:1일 때만 추천
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    // JOIN item item0_ left outer join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id

    // Item N : 1 Partner
    private Partner partner;

    // item 1 : N  OrderDetail
    private List<OrderDetail> orderDetailList;

}
