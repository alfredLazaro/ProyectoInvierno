package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.ServicioEstablecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioEstablecimientoRepository extends JpaRepository<ServicioEstablecimiento, Long> {
}
