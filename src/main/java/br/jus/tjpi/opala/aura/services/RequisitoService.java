package br.jus.tjpi.opala.aura.services;

import br.jus.tjpi.opala.aura.models.EixoModel;
import br.jus.tjpi.opala.aura.models.RequisitoModel;
import br.jus.tjpi.opala.aura.repositories.RequisitoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitoService {

    final RequisitoRepository requisitoRepository;

    public RequisitoService(RequisitoRepository requisitoRepository) {
        this.requisitoRepository = requisitoRepository;
    }

    // Inclusão / Atualização
    @Transactional
    public RequisitoModel salvar(RequisitoModel requisitoModel){
        return requisitoRepository.save(requisitoModel);
    }

    // Listagem Total
    public List<RequisitoModel> listarTodos() {
        return requisitoRepository.findAll();
    }

    // Listagem Individual
    public Optional<RequisitoModel> listarUm(Long id) {
        return requisitoRepository.findById(id);
    }
/*
    // Listagem por Eixo
    public List<RequisitoModel> listarPorEixo(EixoModel eixoModel){
        return requisitoRepository.findByEixo(eixoModel);
    }
*/






}
