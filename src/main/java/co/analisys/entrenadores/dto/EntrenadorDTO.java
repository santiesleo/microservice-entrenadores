package co.analisys.entrenadores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrenadorDTO {
    private String id;
    private String nombre;
    private String especialidad;

}
