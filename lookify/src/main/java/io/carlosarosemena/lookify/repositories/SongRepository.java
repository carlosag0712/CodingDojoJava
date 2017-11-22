package io.carlosarosemena.lookify.repositories;

import io.carlosarosemena.lookify.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> findAll();
    List<Song> findByArtistContaining(String query);
    List<Song> findTop10ByOrderByRatingDesc();

}
