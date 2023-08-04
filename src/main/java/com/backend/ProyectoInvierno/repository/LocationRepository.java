package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
