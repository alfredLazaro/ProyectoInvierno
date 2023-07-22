package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
}
