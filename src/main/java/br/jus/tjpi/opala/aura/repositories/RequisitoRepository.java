package br.jus.tjpi.opala.aura.repositories;

import br.jus.tjpi.opala.aura.models.RequisitoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitoRepository extends JpaRepository<RequisitoModel, Long> {
}
