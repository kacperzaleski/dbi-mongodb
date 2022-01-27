package at.spengergasse.albumwishlistservice.service.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumDto {
    private String albumName;

    private String artistName;

    private boolean onWishlist;
}
