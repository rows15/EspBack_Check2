package com.dh.catalogo.catalogo.repository;

import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository  extends JpaRepository<Serie, Long> {
    List<Serie> findAllByGenre(String genre);
}