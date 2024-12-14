package com.example.TestAPI.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Background extends Article{
	@Column(name = "detailed")
	private BigDecimal detailedPrice;
}
