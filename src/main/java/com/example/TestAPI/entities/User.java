package com.example.TestAPI.entities;

import java.math.BigInteger;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private BigInteger userID;
	
	@Column(name = "Username")
	private String name;
	
	private String email;
	
	private String password;
	
	@Column(name = "isAdmin")
	private Boolean isAdmin;
	
	@OneToMany(mappedBy = "user")
	private Set<Order> orders;
}
