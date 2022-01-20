package at.spengergasse.albumwishlistservice.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@Builder
@RedisHash
public class Album {

    @Id
    private String albumId; //"albumname-artistname"

    @Indexed
    private String albumName;

    private String artistName;

    private boolean onWishlist;



}
