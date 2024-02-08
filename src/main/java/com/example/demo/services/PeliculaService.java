package com.example.demo.services;

import com.example.demo.models.CustomResponse;
import com.example.demo.models.Pelicula;
import com.example.demo.models.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Pelicula> insert(Pelicula pelicula){
        return new CustomResponse<>(
                peliculaRepository.save(pelicula),
                200,
                false,
                "Ok"

        );
    }
    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<Pelicula> update(Pelicula pelicula){
        Optional<Pelicula> pelicula1=peliculaRepository.findById(pelicula.getId());
        if(pelicula1.isPresent()){
            return new CustomResponse<>(
                    peliculaRepository.save(pelicula),
                    200,
                    false,
                    "Ok"

            );
        }else {
            return new CustomResponse<>(
                    null,
                    400,
                    true,
                    "Error pelicula no encontrada"

            );
        }
    }
    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<List<Pelicula>> findAll(){
        return new CustomResponse<>(
                peliculaRepository.findAll(),
                200,
                false,
                "Ok"

        );
    }
    @Transactional(rollbackFor = {Exception.class})
    public CustomResponse<String> delete(Long id){
        Optional<Pelicula> pelicula1=peliculaRepository.findById(id);
        if(pelicula1.isPresent()){
            peliculaRepository.delete(pelicula1.get());
            return new CustomResponse<>(
                    "Todo correcto",
                    200,
                    false,
                    "Ok"

            );
        }else {
            return new CustomResponse<>(
                    null,
                    400,
                    true,
                    "Error pelicula no encontrada"

            );
        }

    }
}
