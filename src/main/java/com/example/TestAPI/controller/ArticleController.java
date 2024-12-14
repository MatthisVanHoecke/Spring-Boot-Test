package com.example.TestAPI.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestAPI.dtos.ArticleDTO;
import com.example.TestAPI.entities.Article;
import com.example.TestAPI.entities.Background;
import com.example.TestAPI.entities.Portrait;
import com.example.TestAPI.service.ArticleService;
import com.example.TestAPI.util.RequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	public ArticleService service;
	
	@GetMapping
	@Operation(summary = "Get a list of articles", description = "Returns a list of articles based on the given request")
	public Page<Article> findAll(@ParameterObject RequestDTO request) {
		if(request.getSortBy() == null) request.setSortBy("articleID");
		return service.findAll(Article.class, request.toRequest());
	}
	
	@GetMapping("/background")
	@Operation(summary = "Get a list of background articles", description = "Returns a list of articles based on the given request")
	public Page<Background> findAllBackgrounds(@ParameterObject RequestDTO request) {
		if(request.getSortBy() == null) request.setSortBy("articleID");
		return service.findAll(Background.class, request.toRequest());
	}
	
	@GetMapping("/portrait")
	@Operation(summary = "Get a list of portrait articles", description = "Returns a list of articles based on the given request")
	public Page<Portrait> findAllPortraits(@ParameterObject RequestDTO request) {
		if(request.getSortBy() == null) request.setSortBy("articleID");
		return service.findAll(Portrait.class, request.toRequest());
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get an article by id", description = "Returns a single article as per id")
	public Article findAll(
			@PathVariable 
			@NotBlank(message = "{article.id.required}") 
			@Min(value = 0, message = "{article.id.negative}")
			@Pattern(regexp = "^[0-9]+$", message = "{article.id.format}") 
			String id
			) {
		return service.findById(id);
	}
	
	@PostMapping
	@Operation(summary = "Add an article", description = "Inserts an article into the database")
	public ResponseEntity<Article> addPlant(@RequestBody @Valid ArticleDTO plant) {
		Article plantEntity = service.insertPlant(plant);
		return ResponseEntity.ok(plantEntity);
	}
}
