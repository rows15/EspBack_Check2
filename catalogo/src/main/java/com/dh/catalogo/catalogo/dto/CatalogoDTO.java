package com.dh.catalogo.catalogo.dto;

import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.entity.Serie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {
    String name;
    List<Movie> movies;
    List<Serie> series;

    public CatalogoDTO(String toUpperCase, List<Movie> movies) {
    }
}
