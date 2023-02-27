package br.jus.tjpi.opala.aura.services;

import br.jus.tjpi.opala.aura.models.EixoModel;
import br.jus.tjpi.opala.aura.repositories.EixoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EixoService {

    final EixoRepository eixoRepository;

    public EixoService(EixoRepository eixoRepository) {
        this.eixoRepository = eixoRepository;
    }

    // Inclusão / Atualização
    @Transactional
    public EixoModel salvar(EixoModel eixoModel){
        return eixoRepository.save(eixoModel);
    }

    // Listagem Total
    public List<EixoModel> listarTodos() {
        return eixoRepository.findAll();
    }

    // Listagem Individual
    public Optional<EixoModel> listarUm(Long id) {
        return eixoRepository.findById(id);
    }

    // Listagem por Ano
    public List<EixoModel> listarPorAno(Integer ano){
        return eixoRepository.findByAno(ano);
    }

    // Listagem por Max Pontos
    public List<EixoModel> listarPorMaxPontos(Integer pontos){
        return eixoRepository.findByMaxPontos(pontos);
    }

    // Exclusão
    @Transactional
    public void excluir(EixoModel eixoModel){
        eixoRepository.delete(eixoModel);
    }
}
