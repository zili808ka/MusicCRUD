package ru.musicians.springmusicians.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.musicians.springmusicians.model.Musician;
import ru.musicians.springmusicians.perository.MusicianRepository;

import java.util.List;

@Service
public class MusicianService {

    @Autowired
    private final MusicianRepository musicianRepository;

    public MusicianService(MusicianRepository musicianRepository) {
        this.musicianRepository = musicianRepository;
    }

    public Musician findById(Long id){
        return musicianRepository.findById(id).orElse(null);
    }

    public List<Musician> findAll(){
        return musicianRepository.findAll();
    }

    public Musician saveMusician(Musician musician){
        return musicianRepository.save(musician);
    }

    public void deleteById(Long id){
        musicianRepository.deleteById(id);
    }
}
