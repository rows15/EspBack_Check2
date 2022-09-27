package com.dh.series.series.queue;



import com.dh.series.series.dto.SerieDTO;
import com.dh.series.series.service.impl.SerieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieListener {

    private final SerieServiceImpl serieService;

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receiveMessage(SerieDTO serieDTO){
        serieService.salvar(serieDTO);
    }

}