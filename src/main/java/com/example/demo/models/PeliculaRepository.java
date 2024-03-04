package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
    Optional<Pelicula> findById(Long id);

    List<Pelicula> findAllByCategoria(Categoria categoria);

    @Query(value="SELECT * " +
            "FROM pelicula " +
            "WHERE director LIKE %:director% " +
            "AND titulo LIKE %:titulo% "
            ,nativeQuery = true)
    List<Pelicula> searchByTitleAndDirectorLike(@Param("titulo") String titulo, @Param("director") String director);

    @Query(value="SELECT * " +
            "FROM pelicula " +
            "WHERE fecha BETWEEN :fecha1 AND :fecha2 "
            ,nativeQuery = true)
    List<Pelicula> getBetween(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);
}
