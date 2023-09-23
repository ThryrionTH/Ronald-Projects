package com.ronaldceballos.lookify.lookify.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronaldceballos.lookify.lookify.Models.Songs;
import com.ronaldceballos.lookify.lookify.Services.LookifyService;

import jakarta.validation.Valid;

@Controller
public class LookifyController {
    private final LookifyService lookifyService;

    public LookifyController(LookifyService lookifyService) {
        this.lookifyService = lookifyService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Songs> song = lookifyService.getAllSongs();
        model.addAttribute("song", song);
        System.out.println("Dashboard page accessed");
        return "dashboard";
    }

    @PostMapping("/search")
    public String searchSongsByArtist(@RequestParam("artist") String artist) {
        return "redirect:/search/" + artist;
    }

    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Songs song) {
        return "new";
    }

    @RequestMapping("/songs/topTen")
    public String showTopTen(Model model) {
        List<Songs> topTenSongs = lookifyService.getTopTenSongs();
        model.addAttribute("topTenSongs", topTenSongs);
        return "topTen";
    }

    @RequestMapping("/search/{artist}")
    public String showSearchResults(@PathVariable("artist") String artist, Model model) {
        List<Songs> searchResults = lookifyService.searchSongsByArtist(artist);
        model.addAttribute("artist", artist);
        model.addAttribute("searchResults", searchResults);
        return "search";
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public String createSong(@Valid @ModelAttribute("song") Songs songs, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        } else {
            lookifyService.createSongs(songs);
            Long createdSongId = songs.getId();
            return "redirect:/songs/" + createdSongId;
        }
    }

    @RequestMapping("songs/{id}")
    public String showSong(@PathVariable("id") Long id, Model model) {
        Songs song = lookifyService.findSongs(id);
        if (song == null) {
            return "error";
        }
        model.addAttribute("song", song);
        return "show";
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
    public String destroySong(@PathVariable("id") Long id) {
        lookifyService.deleteSongs(id);
        return "redirect:/";
    }

}
