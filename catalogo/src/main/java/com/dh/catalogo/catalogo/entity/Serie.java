package com.dh.catalogo.catalogo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Serie implements Serializable {

    @Id
    private Long id;

    private String name;

    private String genre;

    private String urlStream;
}
