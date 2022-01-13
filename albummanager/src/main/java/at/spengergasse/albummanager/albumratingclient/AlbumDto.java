package at.spengergasse.albummanager.albumratingclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class AlbumDto  {


    private String albumName;
    private int length;



}
