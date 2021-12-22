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
    public Album findOne(@PathVariable String name){return albumService.findOneByName(name);}

    @DeleteMapping("/{albumname")
    public void deleteOneAlbum(@PathVariable String name){
        albumService.deleteAlbum(name);
    }

    @PostMapping
    public AlbumDto insertAlbum(@RequestBody AlbumDto album){
        return albumService.insertAlbum(album);
    }

}
