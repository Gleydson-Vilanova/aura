package br.jus.tjpi.opala.aura.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class EixoDto {

    @NotBlank
    private Integer ano;

    @NotBlank
    private String descricao;

    private Integer maxPontos;

    private Integer numRequisitos;

    private Integer numItensPontuacao;

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMaxPontos() {
        return maxPontos;
    }

    public void setMaxPontos(Integer maxPontos) {
        this.maxPontos = maxPontos;
    }

    public Integer getNumRequisitos() {
        return numRequisitos;
    }

    public void setNumRequisitos(Integer numRequisitos) {
        this.numRequisitos = numRequisitos;
    }

    public Integer getNumItensPontuacao() {
        return numItensPontuacao;
    }

    public void setNumItensPontuacao(Integer numItensPontuacao) {
        this.numItensPontuacao = numItensPontuacao;
    }
}
