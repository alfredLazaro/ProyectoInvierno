package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.dto.RestaurantDto;
import com.backend.ProyectoInvierno.model.Establishment;
import com.backend.ProyectoInvierno.model.Location;
import com.backend.ProyectoInvierno.model.ResponsiblePerson;
import com.backend.ProyectoInvierno.repository.EstablishmentRepository;
import com.backend.ProyectoInvierno.repository.LocationRepository;
import com.backend.ProyectoInvierno.repository.PictureRepository;
import com.backend.ProyectoInvierno.repository.ResponsibleRepository;
import com.backend.ProyectoInvierno.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
Nombre del restaurante.
Dirección del restaurante.
Tipo de cocina (por ejemplo, italiana, mexicana, japonesa, etc.).
Horarios de atención.
Número de contacto.
Imágenes del restaurante
 */
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
 private EstablishmentRepository establishmentRepository;
 private RestaurantRepository restaurantRepository;
 private LocationRepository locationRepository;
 private PictureRepository pictureRepository;
 private ResponsibleRepository responsibleRepository;


  public RestaurantController(EstablishmentRepository establishmentRepository,
      RestaurantRepository restaurantRepository, LocationRepository locationRepository,
      PictureRepository pictureRepository, ResponsibleRepository responsibleRepository) {
    this.establishmentRepository = establishmentRepository;
    this.restaurantRepository = restaurantRepository;
    this.locationRepository = locationRepository;
    this.pictureRepository = pictureRepository;
    this.responsibleRepository = responsibleRepository;
  }

  //TODO: save Responsible person
  @PostMapping("/new")
  public Establishment create(@RequestBody RestaurantDto dto){

    Location location = new Location();
    location.setLongitude_location(dto.getLongitude());
    location.setLatitude_location(dto.getLatitude());

    Establishment establishment = new Establishment();

    ResponsiblePerson responsiblePerson = new ResponsiblePerson();
    responsibleRepository.save(responsiblePerson);

    establishment.setName(dto.getRestaurantName());
    establishment.setDescription(dto.getDescription());
    establishment.setOpeningTime(dto.getOpeningTime());
    establishment.setClosing_time(dto.getClosingTime());
    establishment.setLocation(location);
    establishment.setResponsiblePerson(responsiblePerson);

    establishmentRepository.save(establishment);

    //TODO: list of pictures

    return establishment;
  }
  @GetMapping("/all")
  public Iterable<Establishment> getAll(){
    return establishmentRepository.findAll();
  }
  @GetMapping("/{id}")
    public ResponseEntity<ResponsiblePerson> getRestaurant(@PathVariable Long id){
      ResponsiblePerson responsiblePerson = responsibleRepository.findById(id).orElse(null);
      Establishment establishment=responsiblePerson.getEstablishments().stream()
              .findFirst().filter(establishmen -> establishmen.getIdEstablishment() == id).orElse(null);
      ResponsiblePerson auxResponsibl= new ResponsiblePerson();
        auxResponsibl.setId(responsiblePerson.getId());
        auxResponsibl.setName(responsiblePerson.getName());
        List<Establishment> establishments = new ArrayList<>();
        establishments.add(establishment);
        auxResponsibl.setEstablishments(establishments);
      return ResponseEntity.ok(auxResponsibl);
  }

}
