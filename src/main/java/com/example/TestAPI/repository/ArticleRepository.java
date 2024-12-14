package com.example.TestAPI.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.TestAPI.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, String>{
	@Query("SELECT a FROM Article a WHERE TYPE(a) = :type")
	public <T extends Article> Page<T> findByType(@Param("type") Class<T> type, Pageable pageable);
}
