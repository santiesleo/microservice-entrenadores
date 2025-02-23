package co.analisys.entrenadores.repository;

import co.analisys.entrenadores.model.Entrenador;
import co.analisys.entrenadores.model.EntrenadorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, EntrenadorId> {
}
