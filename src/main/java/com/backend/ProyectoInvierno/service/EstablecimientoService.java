package com.backend.ProyectoInvierno.service;

import com.backend.ProyectoInvierno.repository.EstablishmentRepository;
import com.backend.ProyectoInvierno.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablecimientoService {
  private final EstablishmentRepository establecimientoRepository;
  private final LocationRepository ubicacionRepository;

  @Autowired
  public EstablecimientoService(
          EstablishmentRepository establecimientoRepository,
          LocationRepository ubicacionRepository) {
    this.establecimientoRepository = establecimientoRepository;
    this.ubicacionRepository = ubicacionRepository;
  }

/*
  public List<Establecimiento> obtenerEstablecimientosConUbicacion() {
    // Realizar la consulta utilizando join para obtener la información de ambas tablas

    return establecimientoRepository.findAll()
            .stream()
            .peek(establecimiento -> {
              Ubicacion ubicacion = ubicacionRepository.findById(establecimiento.getIdEstablecimiento())
                      .orElse(null);
              establecimiento.setUbicacion(ubicacion);
            })
            .collect(Collectors.toList());
  }
*/

}
