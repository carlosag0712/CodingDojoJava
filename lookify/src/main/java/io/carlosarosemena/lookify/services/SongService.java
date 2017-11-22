package io.carlosarosemena.lookify.services;

import io.carlosarosemena.lookify.model.Song;
import io.carlosarosemena.lookify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public void addSong(Song song){

        songRepository.save(song);

    }

    public Song findOne(Long id){
        return songRepository.findOne(id);
    }

    public void deleteSongById(Long id){
        songRepository.delete(id);
    }

    public List<Song> searchByArtist(String artist){
        return songRepository.findByArtistContaining(artist);
    }

    public List<Song> searchTopTen(){
        return songRepository.findTop10ByOrderByRatingDesc();
    }
}
