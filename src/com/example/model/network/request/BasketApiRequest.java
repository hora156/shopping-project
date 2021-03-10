package com.example.model.network.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketApiRequest {
	
	private int id;
	
	private String status;
	
	private int quantity;
	
	private LocalDateTime createdAt;
	
	private int userId;
	
	private int itemId;
	
}
