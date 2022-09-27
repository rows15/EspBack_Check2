package com.dh.movie.movie.queue;


import com.dh.movie.movie.dto.MovieDTO;
import com.dh.movie.movie.entity.Movie;
import com.dh.movie.movie.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final MovieServiceImpl movieService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMessage(MovieDTO movieDTO){
        movieService.salvar(movieDTO);
    }

}
