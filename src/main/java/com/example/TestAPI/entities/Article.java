package com.example.TestAPI.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.example.TestAPI.dtos.ArticleDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Article")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
	public Article(ArticleDTO plant) {
		this.name = plant.getName();
		this.imageUrl = plant.getImageUrl();
		this.description = plant.getDescription();
		this.price = plant.getPrice();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private BigInteger articleID;
	
	private String name;
	
	private String imageUrl;
	
	private String description;
	
	private BigDecimal price;
}
