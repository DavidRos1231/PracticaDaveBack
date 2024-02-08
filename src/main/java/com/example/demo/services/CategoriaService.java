package com.example.demo.services;

import com.example.demo.models.Categoria;
import com.example.demo.models.CategoriaRepository;
import com.example.demo.models.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Categoria> insert(Categoria categoria){
        return new CustomResponse<>(
                categoriaRepository.save(categoria),
                200,
                false,
                "OK"
        );
    }
    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<List<Categoria>> findAll(){
        return new CustomResponse<>(
                categoriaRepository.findAll(),
                200,
                false,
                "OK"
        );
    }

}
