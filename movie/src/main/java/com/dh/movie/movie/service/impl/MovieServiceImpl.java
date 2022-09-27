package com.dh.movie.movie.service.impl;

import com.dh.movie.movie.dto.MovieDTO;
import com.dh.movie.movie.entity.Movie;
import com.dh.movie.movie.repository.MovieRepository;
import com.dh.movie.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository repository;


    @Override
    public MovieDTO salvar(MovieDTO dto) {
        Movie entity = new Movie();
        entity.setName(dto.getName());
        entity.setUrlStream(dto.getUrlStream());
        entity.setGenre(dto.getGenre());
        return entityToDTO(repository.save(entity));

    }

    @Override
    public List<MovieDTO> pesquisarPorGenero(String generoMovie) {
        return repository.findByGenre(generoMovie)
                .stream().map(this::entityToDTO).collect(Collectors.toList());

    }

    private MovieDTO entityToDTO(Movie entity){
        return MovieDTO.builder().name(entity.getName()).id(entity.getId()).genre(entity.getGenre()).urlStream(entity.getUrlStream()).build();
    }



}
