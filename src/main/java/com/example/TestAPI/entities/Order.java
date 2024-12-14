package com.example.TestAPI.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private BigInteger orderID;
	
	@Column(name = "Date")
	private Date date;
	
	@Column(name = "order_price")
	private BigDecimal price;
	
	@Column(name = "transaction_status", length = 15)
	private String transactionStatus;
	
	@ManyToOne
	@JoinColumn(name = "UserID")
	private User user;
}
