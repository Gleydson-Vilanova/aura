package br.jus.tjpi.opala.aura.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="eixo")

public class EixoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "eixo", fetch = FetchType.EAGER)
    private List<RequisitoModel> requisitos;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer maxPontos;

    private Integer numRequisitos;
    private Integer numItensPontuacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RequisitoModel> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<RequisitoModel> requisitos) {
        this.requisitos = requisitos;
    }

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
