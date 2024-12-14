package com.example.TestAPI;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticleMvcTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void givenArticles_whenGetArticles_thenReturnJsonObject() throws Exception {
		
		mvc.perform(get("/article").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.content", hasSize(5)));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {10, 15, 20, 7})
	public void givenArticles_whenGetArticles_withSizeParameter_returnCorrectPageSize(int size) throws Exception {
		mvc.perform(get(String.format("/article?size=%d", size)).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.pageable.pageSize", is(size)));
	}
}
