package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
    Optional<Pelicula> findById(Long id);
}
