package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.ResponsiblePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<ResponsiblePerson, Long> {
}
