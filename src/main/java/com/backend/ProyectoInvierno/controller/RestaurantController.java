package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.dto.RestaurantDto;
import com.backend.ProyectoInvierno.model.*;
import com.backend.ProyectoInvierno.repository.EstablishmentRepository;
import com.backend.ProyectoInvierno.repository.ResponsibleRepository;
import com.backend.ProyectoInvierno.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private EstablishmentRepository establishmentRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private ResponsibleRepository responsibleRepository;

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }
}
