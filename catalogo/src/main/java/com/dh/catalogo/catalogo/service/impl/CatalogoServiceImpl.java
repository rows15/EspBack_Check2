package com.dh.catalogo.catalogo.service.impl;

import com.dh.catalogo.catalogo.dto.CatalogoDTO;
import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.entity.Serie;
import com.dh.catalogo.catalogo.repository.MovieRepository;
import com.dh.catalogo.catalogo.repository.SerieRepository;
import com.dh.catalogo.catalogo.service.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;


@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {
    private static final Logger log = Logger.getLogger(CatalogoServiceImpl.class.getName());



    private final MovieRepository movieRepository;
    private final SerieRepository serieRepository;

    @Override
    public Movie getMovieById(Long movieId) {

        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    public CatalogoDTO getCatalogByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return new CatalogoDTO(genre.toUpperCase(),movies,series);
    }

    @Override
    public void addNewMovie(Movie movie) {
        movieRepository.save(movie);

    }


    @Override
    public void addNewSerie(Serie serie) {
        serieRepository.save(serie);

    }

}
