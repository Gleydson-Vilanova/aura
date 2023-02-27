package br.jus.tjpi.opala.aura.repositories;

import br.jus.tjpi.opala.aura.models.EixoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EixoRepository extends JpaRepository<EixoModel, Long> {
    List<EixoModel> findByAno(Integer year);
    List<EixoModel> findByMaxPontos(Integer pontos);
}
