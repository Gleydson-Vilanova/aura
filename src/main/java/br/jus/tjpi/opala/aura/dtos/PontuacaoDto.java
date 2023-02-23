package br.jus.tjpi.opala.aura.dtos;

import br.jus.tjpi.opala.aura.models.RequisitoModel;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class PontuacaoDto {
    private RequisitoModel requisito;
    @NotEmpty
    private String descricaoItem;
    private String maxPontos;
    private String tjpiPontos;
    private String formaComprovacao;
    private Date inicioPerRef;
    private Date finalPerRef;

    public RequisitoModel getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoModel requisito) {
        this.requisito = requisito;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public String getMaxPontos() {
        return maxPontos;
    }

    public void setMaxPontos(String maxPontos) {
        this.maxPontos = maxPontos;
    }

    public String getTjpiPontos() {
        return tjpiPontos;
    }

    public void setTjpiPontos(String tjpiPontos) {
        this.tjpiPontos = tjpiPontos;
    }

    public String getFormaComprovacao() {
        return formaComprovacao;
    }

    public void setFormaComprovacao(String formaComprovacao) {
        this.formaComprovacao = formaComprovacao;
    }

    public Date getInicioPerRef() {
        return inicioPerRef;
    }

    public void setInicioPerRef(Date inicioPerRef) {
        this.inicioPerRef = inicioPerRef;
    }

    public Date getFinalPerRef() {
        return finalPerRef;
    }

    public void setFinalPerRef(Date finalPerRef) {
        this.finalPerRef = finalPerRef;
    }
}
