package com.dh.movie.movie.service;

import com.dh.movie.movie.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO salvar(MovieDTO dto);

    List<MovieDTO> pesquisarPorGenero(String generoMovie);

}
