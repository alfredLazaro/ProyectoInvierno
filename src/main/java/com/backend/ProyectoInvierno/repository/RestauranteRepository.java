package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
