package br.jus.tjpi.opala.aura.repositories;

import br.jus.tjpi.opala.aura.models.EixoModel;
import br.jus.tjpi.opala.aura.models.RequisitoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisitoRepository extends JpaRepository<RequisitoModel, Long> {

    List<RequisitoModel> findByEixo(Long id);
}
