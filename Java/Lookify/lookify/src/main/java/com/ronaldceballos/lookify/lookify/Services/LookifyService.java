package com.ronaldceballos.lookify.lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldceballos.lookify.lookify.Models.Songs;
import com.ronaldceballos.lookify.lookify.Repositories.LookifyRepository;

@Service
public class LookifyService {
    private final LookifyRepository lookifyRepository;

    public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }

    public List<Songs> getAllSongs() {
        return lookifyRepository.findAll();
    }

    public Songs createSongs(Songs song) {
        return lookifyRepository.save(song);
    }

    public Songs findSongs(Long id) {
        Optional<Songs> optionalSong = lookifyRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public void deleteSongs(Long id) {
        lookifyRepository.deleteById(id);
    }

    public List<Songs> getTopTenSongs() {
        return lookifyRepository.findTop10ByOrderByRatingDesc();
    }
    
    public List<Songs> searchSongsByArtist(String artist) {
        return lookifyRepository.findByArtist(artist);
    }
    

}
