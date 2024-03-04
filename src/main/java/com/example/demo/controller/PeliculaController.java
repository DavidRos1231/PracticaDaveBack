package com.example.demo.controller;

import com.example.demo.models.CustomResponse;
import com.example.demo.models.Pelicula;
import com.example.demo.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
@CrossOrigin(origins = {"*"})
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/insert")
    public ResponseEntity<CustomResponse<Pelicula>> insert(@RequestBody Pelicula pelicula){
        return new ResponseEntity<>(peliculaService.insert(pelicula), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Pelicula>>> getAll(){
        return new ResponseEntity<>(peliculaService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/getWithFilter/{titulo}/{director}")
    public ResponseEntity<CustomResponse<List<Pelicula>>> getWithFilter(@PathVariable String titulo, @PathVariable String director){
        titulo=titulo.equals("0")?"":titulo;
        director=director.equals("0")?"":director;
        return new ResponseEntity<>(peliculaService.searchByTitleAndDirectorLike(titulo,director), HttpStatus.OK);
    }
    @GetMapping("/getWithCategoria/{categoria}")
    public ResponseEntity<CustomResponse<List<Pelicula>>> getWithCategoria(@PathVariable long categoria){
        return new ResponseEntity<>(peliculaService.searchByCategoria(categoria), HttpStatus.OK);
    }
    @GetMapping("/getBetween/{fecha1}/{fecha2}")
    public ResponseEntity<CustomResponse<List<Pelicula>>> getBetween(@PathVariable String fecha1, @PathVariable String fecha2){
        return new ResponseEntity<>(peliculaService.getBetween(fecha1,fecha2), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<Pelicula>> update(@RequestBody Pelicula pelicula){
        return new ResponseEntity<>(peliculaService.update(pelicula), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomResponse<String>> delete(@PathVariable Long id){
        return new ResponseEntity<>(peliculaService.delete(id),HttpStatus.OK);
    }

}
