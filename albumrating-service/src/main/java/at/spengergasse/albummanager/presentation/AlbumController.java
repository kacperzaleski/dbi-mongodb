package at.spengergasse.albummanager.presentation;

import at.spengergasse.albummanager.domain.Album;
import at.spengergasse.albummanager.service.AlbumService;
import at.spengergasse.albummanager.service.dtos.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {


    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> findAll(){
        return albumService.findAll();
    }

    @GetMapping("/{albumname}")
    public Album findOne(@PathVariable String albumname){return albumService.findOneByName(albumname);}

    @DeleteMapping("/{albumname}")
    public void deleteOneAlbum(@PathVariable String albumname){
        albumService.deleteAlbum(albumname);
    }

    @PostMapping
    public AlbumDto insertAlbum(@RequestBody AlbumDto album){
        return albumService.insertAlbum(album);
    }

}
