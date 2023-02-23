package br.jus.tjpi.opala.aura.dtos;

import br.jus.tjpi.opala.aura.models.EixoModel;
import br.jus.tjpi.opala.aura.models.PontuacaoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class RequisitoDto {

    @NotBlank
    private EixoModel eixo;
    private List<PontuacaoModel> itensPontuacao;
    @NotBlank
    private String artigo;
    @NotBlank
    private String descRequisito;
    private Integer maxPontos;

    public EixoModel getEixo() {
        return eixo;
    }

    public void setEixo(EixoModel eixo) {
        this.eixo = eixo;
    }

    public List<PontuacaoModel> getItensPontuacao() {
        return itensPontuacao;
    }

    public void setItensPontuacao(List<PontuacaoModel> itensPontuacao) {
        this.itensPontuacao = itensPontuacao;
    }

    public String getArtigo() {
        return artigo;
    }

    public void setArtigo(String artigo) {
        this.artigo = artigo;
    }

    public String getDescRequisito() {
        return descRequisito;
    }

    public void setDescRequisito(String descRequisito) {
        this.descRequisito = descRequisito;
    }

    public Integer getMaxPontos() {
        return maxPontos;
    }

    public void setMaxPontos(Integer maxPontos) {
        this.maxPontos = maxPontos;
    }
}
