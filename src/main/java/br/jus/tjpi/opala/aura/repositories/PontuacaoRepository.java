package br.jus.tjpi.opala.aura.repositories;

import br.jus.tjpi.opala.aura.models.PontuacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontuacaoRepository extends JpaRepository<PontuacaoModel, Long> {
}
