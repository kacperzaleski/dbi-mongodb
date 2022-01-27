package at.spengergasse.albumwishlistservice.service;

import at.spengergasse.albumwishlistservice.domain.Album;
import at.spengergasse.albumwishlistservice.persistence.AlbumwishlistRepository;
import at.spengergasse.albumwishlistservice.service.dtos.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumwishlistService {

    private final AlbumwishlistRepository albumwishlistRepository;

    @Autowired
    public AlbumwishlistService(AlbumwishlistRepository repository){
        this.albumwishlistRepository = repository;
    }

    public List<AlbumDto> findAll(){

        List<AlbumDto> list = albumwishlistRepository.findAll().stream().map(a -> {
            return AlbumDto.builder()
                    .albumName(a.getAlbumName())
                    .artistName(a.getArtistName())
                    .onWishlist(a.isOnWishlist()).build();
        }).collect(Collectors.toList());

        return list;
    }

    public AlbumDto findOneById(String albumId){
        Album album =  Optional.of(albumwishlistRepository.findById(albumId)).get().get();

        return AlbumDto.builder()
                .albumName(album.getAlbumName())
                .artistName(album.getArtistName())
                .onWishlist(album.isOnWishlist())
                .build();
    }

    public void insert(AlbumDto album){
        var newalbum = Album.builder()
                .albumId(album.getAlbumName()+"-"+album.getArtistName())
                .albumName(album.getAlbumName())
                .artistName(album.getArtistName())
                .onWishlist(album.isOnWishlist())
                .build();

        albumwishlistRepository.save(newalbum);
    }




}
