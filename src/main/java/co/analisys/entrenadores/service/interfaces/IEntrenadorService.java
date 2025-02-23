package co.analisys.entrenadores.service.interfaces;

import co.analisys.entrenadores.dto.EntrenadorDTO;

import java.util.List;

public interface IEntrenadorService {

    EntrenadorDTO agregarEntrenador(EntrenadorDTO entrenadorDTO);

    List<EntrenadorDTO> obtenerTodosEntrenadores();

    boolean verificarDisponibilidad(String id);
}
