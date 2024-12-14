package com.example.TestAPI.dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleDTO {
	
	@NotNull(message = "{article.name.required}")
	@NotBlank(message = "{article.name.required}")
	@Schema(example = "Headshot", description = "The name of the article")
	private String name;
	
	@NotNull(message = "{article.image.required}")
	@NotBlank(message = "{article.image.required}")
	@Schema(example = "https://exampleurl.png", description = "The url path of the article image")
	private String imageUrl;
	
	@NotNull(message = "{article.description.required}")
	@NotBlank(message = "{article.description.required}")
	@Schema(example = "This article displays...", description = "A detailed description about the article")
	private String description;
	
	@NotNull(message = "{article.price.required}")
	@DecimalMin(value = "0", message = "{article.price.negative}")
	@Schema(example = "15.00", description = "The price of the article")
	private BigDecimal price;
}
