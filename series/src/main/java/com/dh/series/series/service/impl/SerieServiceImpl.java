package com.dh.series.series.service.impl;

import com.dh.series.series.dto.SerieDTO;
import com.dh.series.series.entity.Serie;
import com.dh.series.series.repository.SerieRepository;
import com.dh.series.series.service.SerieService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class SerieServiceImpl implements SerieService {
    private SerieRepository repository;

    private RabbitTemplate rabbitTemplate;

    @Override
    public SerieDTO salvar(SerieDTO dto) {
        Serie entity = new Serie();
        entity.setName(dto.getName());
        entity.setUrlStream(dto.getUrlStream());
        entity.setGenre(dto.getGenre());
        Serie movieSaved = repository.save(entity);
        rabbitTemplate.convertAndSend("movieQueue",entity);
        return entityToDTO(movieSaved);
    }
    private SerieDTO entityToDTO(Serie entity){
        return SerieDTO.builder().name(entity.getName()).id(entity.getId()).genre(entity.getGenre()).urlStream(entity.getUrlStream()).build();
    }

    @Override
    public List<SerieDTO> pesquisarPorGenero(String generoSerie) {
        return repository.findByGenre(generoSerie).stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
