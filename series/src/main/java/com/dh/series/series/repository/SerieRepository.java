package com.dh.series.series.repository;

import com.dh.series.series.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findByGenre(String genre);}
