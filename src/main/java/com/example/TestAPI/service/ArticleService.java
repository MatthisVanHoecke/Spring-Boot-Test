package com.example.TestAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.TestAPI.dtos.ArticleDTO;
import com.example.TestAPI.entities.Article;
import com.example.TestAPI.repository.ArticleRepository;
import com.example.TestAPI.util.Request;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepository repository;
	
	@Autowired
    private MessageSource messageSource;
	
	public <T extends Article> Page<T> findAll(Class<T> type, Request request) {
		Sort sort = Sort.by(request.getSortDirection(), request.getSortBy());
		Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);
		
		if(type == Article.class) return repository.findAll(pageable).map(el -> type.cast(el));
		
		return repository.findByType(type, pageable);
	}
	
	public Article findById(String id) {
		Optional<Article> article = repository.findById(id);
		if(article.isEmpty()) {
			String notFoundMessage = messageSource.getMessage("article.id.notfound", new Object[]{id}, LocaleContextHolder.getLocale());
			throw new EntityNotFoundException(notFoundMessage);
		}
		else return article.get();
	}
	
	public Article insertPlant(ArticleDTO plant) {
		return repository.save(new Article(plant));
	}
}
