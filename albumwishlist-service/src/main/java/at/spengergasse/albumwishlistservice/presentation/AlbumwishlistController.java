package at.spengergasse.albumwishlistservice.presentation;

import at.spengergasse.albumwishlistservice.service.AlbumwishlistService;
import at.spengergasse.albumwishlistservice.service.dtos.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumwishlistController {

    private AlbumwishlistService albumwishlistService;

    @Autowired
    public AlbumwishlistController(AlbumwishlistService albumwishlistService){
        this.albumwishlistService = albumwishlistService;
    }

    @GetMapping()
    public List<AlbumDto> findAll(){
        return albumwishlistService.findAll();
    }
}
