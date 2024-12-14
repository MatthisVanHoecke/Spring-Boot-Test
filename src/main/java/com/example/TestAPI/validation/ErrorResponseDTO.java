package com.example.TestAPI.validation;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    private List<String> errors;
}