package com.example.TestAPI.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Portrait extends Article{
	private BigDecimal extraCharacterPrice;
	
	private String type;
}
