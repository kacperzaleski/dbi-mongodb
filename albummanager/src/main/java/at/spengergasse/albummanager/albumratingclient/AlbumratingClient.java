package at.spengergasse.albummanager.albumratingclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "albumrating-service")
public interface AlbumratingClient {

    @GetMapping(value = "/{albumname}", produces = APPLICATION_JSON_VALUE)
    AlbumDto findOne(@PathVariable String albumname);

    @GetMapping()
    List<AlbumDto> findAll();
}
