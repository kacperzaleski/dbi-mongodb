package at.spengergasse.integration;


import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;


@Testcontainers
class IntegrationTest {

    @Container
    private static final GenericContainer albummanagerContainer =
            new GenericContainer("albummanager:0.0.1-SNAPSHOT");

    @Container
    private static final GenericContainer albumratingContainer =
            new GenericContainer("albumrating-service:0.0.1-SNAPSHOT");

    @Container
    private static final DockerComposeContainer composeContainer =
            new DockerComposeContainer(
                    new File("../docker-compose.yaml")
            );
    @Test
    void test(){
        System.out.println(albummanagerContainer.isCreated());
        System.out.println(albummanagerContainer.isHealthy());
        System.out.println(albummanagerContainer.isRunning());
    }

}
