package com.rdg.GerenciamentoAutores.service;

import com.rdg.GerenciamentoAutores.models.AutoresModels;
import com.rdg.GerenciamentoAutores.repository.AutoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresService {

    private final AutoresRepository autoresRepository;

    public AutoresService(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    public AutoresModels save(AutoresModels autorModel) {
        return autoresRepository.save(autorModel);
    }

    public List<AutoresModels> findAll(){
        return autoresRepository.findAll();
    }

    public void delete(Long id) {
        autoresRepository.deleteById(id);
    }

    public AutoresModels update(Long id, AutoresModels autoresModel) {
        AutoresModels autores = autoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        autores.setNome(autoresModel.getNome());
        autores.setDataNascimento(autoresModel.getDataNascimento());
        autores.setNacionalidade(autoresModel.getNacionalidade());

        return autoresRepository.save(autores);
    }


    public AutoresModels findById(Long id) {
        return autoresRepository.findById(id).orElse(null);
    }
}