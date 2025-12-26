package com.brando_miranda.demo.DTOs;

import java.time.LocalDateTime;

public record AvaliacaoResponse(
    String id,
    String name,
    Integer nota,
    String comentario,
    LocalDateTime dataPub
) {

}
