package com.dh.catalogo.catalogo.service;

import com.dh.catalogo.catalogo.dto.CatalogoDTO;
import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.entity.Serie;

public interface CatalogoService {

    Movie getMovieById(Long movieId);

    CatalogoDTO getCatalogByGenre(String genre);

    void addNewMovie(Movie movie);

    void addNewSerie(Serie serie);
}
