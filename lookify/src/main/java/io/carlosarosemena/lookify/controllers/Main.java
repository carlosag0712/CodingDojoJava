package io.carlosarosemena.lookify.controllers;


import io.carlosarosemena.lookify.model.Song;
import io.carlosarosemena.lookify.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Main {

    @Autowired
    SongService songService;

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/dashboard")
    public String dashboard(@ModelAttribute("song")Song song, Model model){
        model.addAttribute("songs", songService.findAll());
        return "dashboard";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("artist") String artist){
        return "redirect:/search/".concat(artist);
    }

    @RequestMapping("/search/{artist}")
    public String  searchResult(@PathVariable("artist") String artist, Model model){
        model.addAttribute("artist", artist);
        List<Song> songs = songService.searchByArtist(artist);

        if(songs.isEmpty()){
            return "redirect:/dashboard";
        }else{
            model.addAttribute("songs", songService.searchByArtist(artist));
            return "result";
        }
    }

    @RequestMapping("/search/topTen")
    public String topTen(Model model){
        model.addAttribute("songs", songService.searchTopTen());
        return "topTen";
    }
}
