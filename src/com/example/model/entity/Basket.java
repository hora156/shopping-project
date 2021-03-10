package com.example.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {
	
	private int id;
	
	private String status;
	
	private int quantity;
	
	private LocalDateTime createdAt;
	
	private int userId;
	
	private int itemId;
	
}
