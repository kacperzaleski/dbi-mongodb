package at.spengergasse.albummanager.service;

import at.spengergasse.albummanager.albumratingclient.AlbumDto;
import at.spengergasse.albummanager.albumratingclient.AlbumratingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbummanagerService {

    private AlbumratingClient albumratingClient;

    public AlbummanagerService(AlbumratingClient albumratingClient){
        this.albumratingClient = albumratingClient;
    }

    public List<AlbumDto> showAlbumlist(){
        return albumratingClient.findAll();
    }
}
