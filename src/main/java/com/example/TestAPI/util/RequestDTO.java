package com.example.TestAPI.util;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
	@Nullable
	@Min(0)
	@Schema(description = "The list size")
	private Integer size;
	@Nullable
	@Min(0)
	@Schema(description = "The current list page")
	private Integer page;
	@Nullable
	@Schema(description = "The field to sort on")
	private String sortBy;
	@Nullable
	@Schema(description = "The sorting direction")
	private Direction sortDirection;
	
	public Request toRequest() {
		Request.RequestBuilder builder = Request.builder();
		if(size != null) builder.size(size);
		if(page != null) builder.page(page);
		if(sortBy != null) builder.sortBy(sortBy);
		if(sortDirection != null) builder.sortDirection(sortDirection);
		return builder.build();
	}
}
