package com.dh.catalogo.catalogo.queue;


import com.dh.catalogo.catalogo.entity.Serie;
import com.dh.catalogo.catalogo.service.impl.CatalogoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieListener {
    private final CatalogoServiceImpl catalogoService;
    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receiveMessage(Serie serie){catalogoService.addNewSerie(serie);}
}
