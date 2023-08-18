package com.backend.ProyectoInvierno.repository;

import com.backend.ProyectoInvierno.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query("SELECT r FROM Restaurant r ")
    List<Restaurant> findAllRestauranWithEstablishment();
}
