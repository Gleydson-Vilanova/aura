package br.jus.tjpi.opala.aura.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Pontuacao")

public class PontuacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requisito_id")
    private RequisitoModel requisito;

    @Column(nullable = false)
    private String descricaoItem;

    @Column(nullable = false)
    private String maxPontos;

    @Column(nullable = false)
    private String tjpiPontos;

    private String formaComprovacao;

    private Date inicioPerRef;

    private Date finalPerRef;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
