package com.backend.ProyectoInvierno.service;

import com.backend.ProyectoInvierno.repository.EstablecimientoRepository;
import com.backend.ProyectoInvierno.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstablecimientoService {
  private final EstablecimientoRepository establecimientoRepository;
  private final UbicacionRepository ubicacionRepository;

  @Autowired
  public EstablecimientoService(
          EstablecimientoRepository establecimientoRepository,
          UbicacionRepository ubicacionRepository) {
    this.establecimientoRepository = establecimientoRepository;
    this.ubicacionRepository = ubicacionRepository;
  }

//  public List<Establecimiento> obtenerEstablecimientosConUbicacion() {
//    // Realizar la consulta utilizando join para obtener la información de ambas tablas
//    return establecimientoRepository.findAll()
//            .stream()
//            .peek(establecimiento -> {
//              Ubicacion ubicacion = ubicacionRepository.findById(establecimiento.getId_establecimiento())
//                      .orElse(null);
//              establecimiento.setUbicacion(ubicacion);
//            })
//            .collect(Collectors.toList());
//  }

}
