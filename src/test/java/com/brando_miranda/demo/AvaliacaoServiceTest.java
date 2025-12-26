package com.brando_miranda.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.brando_miranda.demo.DTOs.AvaliacaoRequest;
import com.brando_miranda.demo.DTOs.AvaliacaoResponse; 
import com.brando_miranda.demo.business.AvaliacaoService;
import com.brando_miranda.demo.model.Avaliacao;
import com.brando_miranda.demo.repository.AvaliacaoRepository;



@ExtendWith(MockitoExtension.class) 
public class AvaliacaoServiceTest {

    @Mock
    private AvaliacaoRepository repository; 

    @InjectMocks
    private AvaliacaoService service; 

    @Test
    @DisplayName("Deve criar uma avaliação com sucesso")
    void deveCriarAvaliacao() {
       
        AvaliacaoRequest request = new AvaliacaoRequest("Hildebrando", 5, "Ótima API!");
        
        Avaliacao avaliacaoNoBanco = Avaliacao.builder()
                .id("123")
                .name("Hildebrando")
                .nota(5)
                .comentario("Ótima API!")
                .build();

        
        when(repository.save(any(Avaliacao.class))).thenReturn(avaliacaoNoBanco);

        
        AvaliacaoResponse resultado = service.create(request);

       
        assertNotNull(resultado);
        assertEquals("Hildebrando", resultado.name()); // Se AvaliacaoResponse for Record, usa name() sem o "get"
        assertEquals(5, resultado.nota());
        
        verify(repository, times(1)).save(any(Avaliacao.class));
    }

    @Test
    @DisplayName("Deve lançar exceção quando a avaliação não for encontrada")
    void deveLancarExcecaoQuandoNaoEncontrado() {
        
        String idInexistente = "999";
        
      
        Mockito.when(repository.findById(idInexistente)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.update(idInexistente, new AvaliacaoRequest("Erro", 1, ""));
        });

        
        assertEquals("Avaliação não encontrada", exception.getMessage());
        
        
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }
}