package com.brando_miranda.demo.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.brando_miranda.demo.model.Avaliacao;
import com.brando_miranda.demo.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    
        }

        public Avaliacao createAvaliacao(Avaliacao avaliacao) {
            return avaliacaoRepository.save(avaliacao);

        }

        public List<Avaliacao> listAllAvaliacao(){
            return avaliacaoRepository.findAll();
        }

        public Optional<Avaliacao> getUserById(String id) {
        return avaliacaoRepository.findById(id);

       }

       public Avaliacao updateAvaliacao(String id,Avaliacao avaliacaoDetails) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElse(null);
        if(avaliacao != null) {
            avaliacao.setName(avaliacaoDetails.getName());
            avaliacao.setNota(avaliacaoDetails.getNota());
            avaliacao.setComentario(avaliacaoDetails.getComentario());
            avaliacao.setDataPub(avaliacaoDetails.getDataPub());
        } return null;
    
       }

       public void deleteAvaliacao(@PathVariable String id){
          avaliacaoRepository.deleteById(id);
       }

}
