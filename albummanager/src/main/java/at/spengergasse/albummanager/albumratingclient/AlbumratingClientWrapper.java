package at.spengergasse.albummanager.albumratingclient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumratingClientWrapper {

    private final AlbumratingClient albumratingClient;

    public AlbumratingClientWrapper(AlbumratingClient albumratingClient){
        this.albumratingClient = albumratingClient;
    }

    @CircuitBreaker(name = "albumrating-client", fallbackMethod = "fallback_findOneAlbum")
    public AlbumDto findOne(String albumname) {return albumratingClient.findOne(albumname);}

    public AlbumDto fallback_findOneAlbum(String name, Throwable throwable){
        return AlbumDto.builder().albumName(name).build();
    }
}
