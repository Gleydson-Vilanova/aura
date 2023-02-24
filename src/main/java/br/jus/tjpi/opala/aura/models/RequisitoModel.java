package br.jus.tjpi.opala.aura.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="requisito")

public class RequisitoModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "eixo_id")
    private EixoModel eixo;

    @OneToMany(mappedBy = "requisito", fetch = FetchType.EAGER)
    private List<PontuacaoModel> itensPontuacao;

    @Column(nullable = false)
    private String artigo;

    @Column(nullable = false)
    private String descRequisito;

    @Column(nullable = false)
    private Integer maxPontos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
