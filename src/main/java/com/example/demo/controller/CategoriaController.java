package com.example.demo.controller;

import com.example.demo.models.Categoria;
import com.example.demo.models.CustomResponse;
import com.example.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = {"*"})
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/insert")
    public ResponseEntity<CustomResponse<Categoria>> insert(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.insert(categoria), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Categoria>>> getAll(){
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

}
