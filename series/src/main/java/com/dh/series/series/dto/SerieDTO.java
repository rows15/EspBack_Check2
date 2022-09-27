package com.dh.series.series.dto;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SerieDTO implements Serializable {

    private Long id;

    private String name;

    private String genre;

    private String urlStream;

}