package at.spengergasse.albummanager.service.dtos;

import at.spengergasse.albummanager.domain.Artist;
import at.spengergasse.albummanager.domain.Song;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class AlbumDto {
    private String albumName;
    private int length;
    private Artist artist;


    private List<Song> songs;
}
