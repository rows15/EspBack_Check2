package com.dh.movie.movie;


import com.dh.movie.movie.dto.MovieDTO;
import com.dh.movie.movie.entity.Movie;
import com.dh.movie.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//#@RequestMapping("/")
@RestController
public class MovieController {


    @Autowired
    private MovieService service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private ResponseEntity<MovieDTO> salvar(@RequestBody MovieDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/genero/{genero}")
    private ResponseEntity<List<MovieDTO>> pesquisarPorGenero(@PathVariable String genero){
        return ResponseEntity.ok(service.pesquisarPorGenero(genero));
    }




}
