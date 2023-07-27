package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.Establishment;
import com.backend.ProyectoInvierno.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serv/establecimiento")
public class EstablishmentController {
    @Autowired
    private EstablishmentRepository establishmentRepository;

    @GetMapping
    public List<Establishment> getAllEstablishments(){
        return establishmentRepository.findAll();
    }

    @PostMapping
    public Establishment createEstablishment(@RequestBody Establishment establishment){
        return establishmentRepository.save(establishment);
    }
}
