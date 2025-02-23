package co.analisys.entrenadores.service.impl;

import co.analisys.entrenadores.dto.EntrenadorDTO;
import co.analisys.entrenadores.model.Entrenador;
import co.analisys.entrenadores.model.EntrenadorId;
import co.analisys.entrenadores.repository.EntrenadorRepository;
import co.analisys.entrenadores.service.interfaces.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrenadorServiceImpl implements IEntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorServiceImpl(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    @Override
    public EntrenadorDTO agregarEntrenador(EntrenadorDTO entrenadorDTO) {
        Entrenador entrenador = mapToEntity(entrenadorDTO);
        Entrenador savedEntrenador = entrenadorRepository.save(entrenador);
        return mapToDTO(savedEntrenador);
    }

    @Override
    public List<EntrenadorDTO> obtenerTodosEntrenadores() {
        return entrenadorRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public boolean verificarDisponibilidad(String id) {
        return entrenadorRepository.findById(new EntrenadorId(id)).isPresent();
    }

    private Entrenador mapToEntity(EntrenadorDTO dto) {
        EntrenadorId entrenadorId = new EntrenadorId(dto.getId());
        return new Entrenador(entrenadorId, dto.getNombre(), dto.getEspecialidad());
    }

    private EntrenadorDTO mapToDTO(Entrenador entrenador) {
        EntrenadorDTO dto = new EntrenadorDTO();
        dto.setId(entrenador.getId().getEntrenadorIdValue());
        dto.setNombre(entrenador.getNombre());
        dto.setEspecialidad(entrenador.getEspecialidad());
        return dto;
    }
}
