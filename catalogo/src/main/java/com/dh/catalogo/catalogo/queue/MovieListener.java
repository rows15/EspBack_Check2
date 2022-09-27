package com.dh.catalogo.catalogo.queue;

import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.service.impl.CatalogoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieListener {
    private final CatalogoServiceImpl catalogService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMessage(Movie movie){ catalogService.addNewMovie(movie);}
}
