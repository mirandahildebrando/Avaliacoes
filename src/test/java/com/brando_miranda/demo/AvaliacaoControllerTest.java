package com.brando_miranda.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType; 
import org.springframework.test.web.servlet.MockMvc;

import com.brando_miranda.demo.controller.AvaliacaoController;
import com.brando_miranda.demo.business.AvaliacaoService;

@WebMvcTest(AvaliacaoController.class)
public class AvaliacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AvaliacaoService service; // Mockamos o service para o teste focar só no Controller

    @Test
    @DisplayName("Deve retornar 201 ao criar avaliação válida")
    void deveCriarComSucesso() throws Exception {
        String json = "{\"name\": \"Hildebrando\", \"nota\": 5, \"comentario\": \"Muito bom!\"}";

        mockMvc.perform(post("/avaliacoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Deve retornar 400 quando os dados forem inválidos")
    void deveRetornarErroValidacao() throws Exception {

        String json = "{\"name\": \"\", \"nota\": 10}";

        mockMvc.perform(post("/avaliacoes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest()); 
    }
}
