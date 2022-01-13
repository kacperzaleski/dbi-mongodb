package at.spengergasse.albummanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlbummanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbummanagerApplication.class, args);
    }

}
