package com.example.TestAPI.util;

import org.springframework.data.domain.Sort.Direction;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Request {
	@Builder.Default
	private int size = 20;
	@Builder.Default
	private int page = 0;
	@Builder.Default
	private String sortBy = "id";
	@Builder.Default
	private Direction sortDirection = Direction.DESC;
}
