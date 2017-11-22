package io.carlosarosemena.lookify.controllers;

import io.carlosarosemena.lookify.model.Song;
import io.carlosarosemena.lookify.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class Songs {

    @Autowired
    SongService songService;

    @RequestMapping("songs/new")
    public String newSong(@ModelAttribute("song")Song song ){


        return "new";
    }

    @RequestMapping("/songs")
    public String createSong(@Valid @ModelAttribute("song")Song song, BindingResult result){
        if(result.hasErrors()){
            return "new";
        }else{

            songService.addSong(song);
            return "redirect:/dashboard";

        }
    }

    @RequestMapping("/songs/{id}")
    public String showSong(@PathVariable("id")Long id, Model model){
        model.addAttribute("song", songService.findOne(id));
        return "show";
    }

    @RequestMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id){
        songService.deleteSongById(id);
        return "redirect:/dashboard";
    }







}
