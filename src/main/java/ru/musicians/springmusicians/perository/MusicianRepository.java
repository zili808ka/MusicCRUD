package ru.musicians.springmusicians.perository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.musicians.springmusicians.model.Musician;

import java.util.List;

public interface MusicianRepository extends JpaRepository<Musician, Long> {
}
