package com.dh.series.series;

import com.dh.series.series.dto.SerieDTO;
import com.dh.series.series.service.SerieService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SerieController {

    @Autowired
    private SerieService service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private ResponseEntity<SerieDTO> salvar(@RequestBody SerieDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/genero/{genero}")
    private ResponseEntity<List<SerieDTO>> pesquisarPorGenero(@PathVariable String genero){
        return ResponseEntity.ok(service.pesquisarPorGenero(genero));
    }
}
