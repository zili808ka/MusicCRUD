package ru.musicians.springmusicians.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.musicians.springmusicians.model.Musician;
import ru.musicians.springmusicians.service.MusicianService;

import java.util.List;

@Controller
public class MusicianController {

    @Autowired
    private final MusicianService musicianService;

    public MusicianController(MusicianService musicianService) {
        this.musicianService = musicianService;
    }

    @GetMapping("/musicians")
    public String findAll(Model model){
        List<Musician> musicians = musicianService.findAll();
        model.addAttribute("musicians", musicians);
        return "musician-list";
    }

    @GetMapping("/musician-create")
    public String createMusicianForm(Musician musician){
        return "musician-create";
    }

    @PostMapping("/musician-create")
    public String createMusician(Musician musician){
        musicianService.saveMusician(musician);
        return "redirect:/musicians";
    }

    @GetMapping("musician-delete/{id}")
    public String deleteMusician(@PathVariable("id") Long id){
        musicianService.deleteById(id);
        return "redirect:/musicians";
    }

    @GetMapping("/musician-update/{id}")
    public String updateMusicianForm(@PathVariable("id") Long id, Model model){
        Musician musician = musicianService.findById(id);
        model.addAttribute("musician", musician);
        return "/musician-update";
    }

    @PostMapping("/musician-update")
    public String updateMusician(Musician musician){
        musicianService.saveMusician(musician);
        return "redirect:/musicians";
    }
}
