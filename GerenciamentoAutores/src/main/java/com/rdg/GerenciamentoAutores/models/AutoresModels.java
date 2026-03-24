package com.rdg.GerenciamentoAutores.models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_autores")
public class AutoresModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeAutor")
    private String nome;
    @Column(name = "nacionaliadeAutor")
    private String nacionalidade;
    private LocalDate dataNascimento;

    public AutoresModels() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

}
