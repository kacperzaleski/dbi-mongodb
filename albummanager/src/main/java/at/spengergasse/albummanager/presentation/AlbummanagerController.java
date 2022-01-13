package at.spengergasse.albummanager.presentation;


import at.spengergasse.albummanager.albumratingclient.AlbumDto;
import at.spengergasse.albummanager.service.AlbummanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/albummanager")
public class AlbummanagerController {

    private final AlbummanagerService albummanagerService;

    @Autowired
    public AlbummanagerController(AlbummanagerService albummanagerService){
        this.albummanagerService = albummanagerService;
    }

    @GetMapping()
    public List<AlbumDto> showAllAlbums(){
        return albummanagerService.showAlbumlist();
    }






}
