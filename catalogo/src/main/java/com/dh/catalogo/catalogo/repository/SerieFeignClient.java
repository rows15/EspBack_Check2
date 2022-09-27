package com.dh.catalogo.catalogo.repository;

import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.entity.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name = "SERIE-SERVICE")
public interface SerieFeignClient {
    @GetMapping("/serie/{genre}")
    List<Serie> getSeriesByGenre(@PathVariable String genre);

    @GetMapping("/serie/id/{movieId}")
    Serie getSerieById(@PathVariable Long serieId);

    @PostMapping("/serie/save")
    Serie saveNewSerie(@RequestBody Serie serie);
}



