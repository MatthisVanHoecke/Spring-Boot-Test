package com.example.TestAPI.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Orderline")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orderline {
	@Id
	@ManyToOne
	@JoinColumn(name = "ArticleID")
	private Article article;
	
	private String status;
	
	@Column(name = "UserDescription")
	private String userDescription;
	
	@Column(name = "priceByOrder")
	private BigDecimal priceByOrder;
	
	@Column(name = "CharacterAmount")
	private int characterAmount;
	
	@Column(name = "ReferenceImageUrl")
	private String referenceImageUrl;
}
