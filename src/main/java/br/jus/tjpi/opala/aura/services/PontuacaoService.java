package br.jus.tjpi.opala.aura.services;

import br.jus.tjpi.opala.aura.models.PontuacaoModel;
import br.jus.tjpi.opala.aura.repositories.EixoRepository;
import br.jus.tjpi.opala.aura.repositories.PontuacaoRepository;

import java.util.List;
import java.util.Optional;

public class PontuacaoService {

    final PontuacaoRepository eixoRepository;

    public PontuacaoService(PontuacaoRepository eixoRepository) {
        this.eixoRepository = eixoRepository;
    }

    public PontuacaoModel salvar(PontuacaoModel pontuacaoModel) {
       return eixoRepository.save(pontuacaoModel);
    }

    public List<PontuacaoModel> listarTodos() {
        return eixoRepository.findAll();
    }

    public Optional<PontuacaoModel> listarUm(Long id) {
        return eixoRepository.findById(id);
    }

    public void excluir(PontuacaoModel pontuacaoModel) {
        eixoRepository.delete(pontuacaoModel);
    }
}
