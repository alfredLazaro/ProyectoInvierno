package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.dto.RestaurantDto;
import com.backend.ProyectoInvierno.model.Establishment;
import com.backend.ProyectoInvierno.model.Location;
import com.backend.ProyectoInvierno.model.Picture;
import com.backend.ProyectoInvierno.model.ResponsiblePerson;
import com.backend.ProyectoInvierno.repository.EstablishmentRepository;
import com.backend.ProyectoInvierno.repository.LocationRepository;
import com.backend.ProyectoInvierno.repository.PictureRepository;
import com.backend.ProyectoInvierno.repository.ResponsibleRepository;
import com.backend.ProyectoInvierno.repository.RestaurantRepository;
import java.sql.Time;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
