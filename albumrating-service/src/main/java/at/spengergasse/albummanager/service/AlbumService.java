package at.spengergasse.albummanager.service;

import at.spengergasse.albummanager.domain.Album;
import at.spengergasse.albummanager.persistence.AlbumRepository;
import at.spengergasse.albummanager.service.dtos.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album findOneByName(String name) {
        return albumRepository.findAlbumByAlbumName(name);
    }

    public void deleteAlbum(String name){
        albumRepository.deleteAlbumByAlbumName(name);
    }

    public AlbumDto insertAlbum(AlbumDto newAlbum){
        Album album = new Album(newAlbum.getAlbumName(),
                newAlbum.getLength(),
                newAlbum.getArtist(),
                newAlbum.getSongs());
        albumRepository.insert(album);
        return AlbumDto.builder().albumName(album.getAlbumName())
                .artist(album.getArtist())
                .length(album.getLength())
                .songs(album.getSongs())
                .build();
    }
}
