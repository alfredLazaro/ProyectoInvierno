package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Long> {
}
