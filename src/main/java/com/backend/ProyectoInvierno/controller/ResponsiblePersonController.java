package com.backend.ProyectoInvierno.controller;

import com.backend.ProyectoInvierno.model.ResponsiblePerson;
import com.backend.ProyectoInvierno.repository.ResponsibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serv/encargado")
public class ResponsiblePersonController {

    @Autowired
    private ResponsibleRepository responsibleRepository;

    @PostMapping
    public ResponsiblePerson createResponsible(@RequestBody ResponsiblePerson responsiblePerson){
        return responsibleRepository.save(responsiblePerson);
    }
}
