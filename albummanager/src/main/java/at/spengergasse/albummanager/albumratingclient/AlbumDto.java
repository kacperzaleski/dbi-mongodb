package at.spengergasse.albummanager.albumratingclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class AlbumDto  {


    private String albumName;
    private int length;



}
