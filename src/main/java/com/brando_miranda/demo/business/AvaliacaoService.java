package com.brando_miranda.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.brando_miranda.demo.DTOs.AvaliacaoRequest;
import com.brando_miranda.demo.DTOs.AvaliacaoResponse;
import com.brando_miranda.demo.model.Avaliacao;
import com.brando_miranda.demo.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    
        }

        public AvaliacaoResponse create(AvaliacaoRequest request) {
     Avaliacao entidade = Avaliacao.builder()
            .name(request.name())
            .nota(request.nota())
            .comentario(request.comentario())
            .build();
    Avaliacao salva = avaliacaoRepository.save(entidade);
    return new AvaliacaoResponse(
        salva.getId(), 
        salva.getName(), 
        salva.getNota(), 
        salva.getComentario(), 
        salva.getDataPub()
    );
}

        public List<AvaliacaoResponse> listAll() {
        return avaliacaoRepository.findAll().stream()
        .map(this::convertToResponse) 
        .toList();
        }

        public Optional<AvaliacaoResponse> getById(String id) {
        return avaliacaoRepository.findById(id)
        .map(this::convertToResponse);
         }

         private AvaliacaoResponse convertToResponse(Avaliacao avaliacao) {
            return new AvaliacaoResponse(
                avaliacao.getId(),
                avaliacao.getName(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getDataPub()
            );
         }



       public Avaliacao update(String id, AvaliacaoRequest dto) {
         return avaliacaoRepository.findById(id)
         .map(existente -> {
            existente.setName(dto.name());
            existente.setNota(dto.nota());
            existente.setComentario(dto.comentario());
            return avaliacaoRepository.save(existente);
         })
         .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    
       }

       public void delete(@PathVariable String id){
          avaliacaoRepository.deleteById(id);
       }

}
