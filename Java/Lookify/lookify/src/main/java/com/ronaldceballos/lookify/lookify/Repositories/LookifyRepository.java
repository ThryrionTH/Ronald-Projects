package com.ronaldceballos.lookify.lookify.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ronaldceballos.lookify.lookify.Models.Songs;

public interface LookifyRepository extends CrudRepository<Songs, Long> {
    List<Songs> findAll();
    List<Songs> findByArtist(String artist);
    List<Songs> findTop10ByOrderByRatingDesc();
}
