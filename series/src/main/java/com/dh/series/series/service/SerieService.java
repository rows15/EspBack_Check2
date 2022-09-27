package com.dh.series.series.service;

import com.dh.series.series.dto.SerieDTO;

import java.util.List;

public interface SerieService {

    SerieDTO salvar(SerieDTO dto);

    List<SerieDTO> pesquisarPorGenero(String generoSerie);
}
