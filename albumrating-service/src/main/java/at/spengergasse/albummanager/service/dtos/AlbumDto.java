package at.spengergasse.albummanager.service.dtos;

import at.spengergasse.albummanager.domain.Artist;
import at.spengergasse.albummanager.domain.Song;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AlbumDto {
    private String albumName;
    private int length;
    private Artist artist;
    private float rating;


    private List<Song> songs;
}
