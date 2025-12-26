package com.brando_miranda.demo.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AvaliacaoRequest(
    @NotBlank String name,
    @Min(0) @Max(5) Integer nota,
    @Size(max = 500) String comentario
) {

}
