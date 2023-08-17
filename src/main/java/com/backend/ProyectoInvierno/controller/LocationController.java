package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.Location;
import com.backend.ProyectoInvierno.repository.EstablishmentRepository;
import com.backend.ProyectoInvierno.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/location")
public class LocationController {
  @Autowired
  private EstablishmentRepository establishmentRepository;
  @Autowired
  private LocationRepository locationRepository;

  @PutMapping()
  public Location createLocationInStablishment(@RequestBody Location location) {
    return locationRepository.save(location);
  }

  @GetMapping
  public List<Location> listaLoc() {
    return locationRepository.findAll();
  }
}
