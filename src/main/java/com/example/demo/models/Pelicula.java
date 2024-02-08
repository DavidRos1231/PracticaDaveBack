package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pelicula")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "titulo",length = 100,nullable = false)
    public String titulo;

    @Column(name = "director",length = 50,nullable = false)
    public String director;

    @ManyToOne
    @JoinColumn(name = "categoria",nullable = false)
    @JsonIgnoreProperties("peliculas")
    public Categoria categoria;

    @Column(name = "duracion",length = 5,nullable = false)
    public String duracion;

    @Column(name = "enlace",length = 255,nullable = true)
    public String enlace;

}
