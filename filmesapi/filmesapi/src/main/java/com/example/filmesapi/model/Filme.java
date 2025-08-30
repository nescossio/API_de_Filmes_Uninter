package com.example.filmesapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @Column(name = "id")
    private String id;

    @NotBlank(message = "O título é obrigatório")
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Min(value = 1888, message = "Ano de lançamento inválido")
    @Max(value = 2100, message = "Ano de lançamento inválido")
    @Column(name = "ano_lancamento")
    private int anoLancamento;

    @NotBlank(message = "O gênero é obrigatório")
    @Column(name = "genero", nullable = false)
    private String genero;

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
