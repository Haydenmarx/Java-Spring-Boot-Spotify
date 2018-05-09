
package com.example.songsapi.controllers;

import com.example.songsapi.models.Song;
import com.example.songsapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongsController {
  @Autowired
  private SongRepository songRepository;

  @GetMapping("/songs")
  public Iterable<Song> findAllSongs() {
    return songRepository.findAll();
  }

  @GetMapping("/songs/{songId}")
  public Song findSongById(@PathVariable Long songId) {
    return songRepository.findOne(songId);
  }

  @DeleteMapping("/songs/{songId}")
  public HttpStatus deleteUserById(@PathVariable Long songId) {
    songRepository.delete(songId);
    return HttpStatus.OK;
  }

  @PostMapping("/songs")
  public Song createNewUser(@RequestBody Song newSong) {
    return songRepository.save(newSong);
  }

  @PatchMapping("/songs/{songId}")
  public Song updateSongById(@PathVariable Long songId, @RequestBody Song userRequest) {

    Song songFromDb = songRepository.findOne(songId);

    songFromDb.setSongTitle(userRequest.getSongTitle());
    songFromDb.setSongArtist(userRequest.getSongArtist());
    songFromDb.setSongLength(userRequest.getSongLength());

    return songRepository.save(songFromDb);
  }

}
