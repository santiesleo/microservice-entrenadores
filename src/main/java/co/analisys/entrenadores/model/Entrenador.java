package co.analisys.entrenadores.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrenador {
    @EmbeddedId
    private EntrenadorId id;
    private String nombre;
    @Embedded
    private Especialidad especialidad;
}
