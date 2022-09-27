package com.dh.catalogo.catalogo;

import com.dh.catalogo.catalogo.service.impl.CatalogoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogoController {

    private final CatalogoServiceImpl catalogoService;

    @GetMapping("/{genero}")
    public ResponseEntity<?> getCatalogByGenre(@PathVariable String genre){
        return ResponseEntity.status(HttpStatus.OK).body(catalogoService.getCatalogByGenre(genre));
    }
}
