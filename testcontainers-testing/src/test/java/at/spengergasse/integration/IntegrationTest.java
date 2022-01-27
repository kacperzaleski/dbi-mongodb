package at.spengergasse.integration;


import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;


@Testcontainers
class IntegrationTest {


    @ClassRule
    private static final DockerComposeContainer composeContainer =
            new DockerComposeContainer(
                    new File("../docker-compose.yaml")
            );
    @Test
    void test(){
        System.out.println(composeContainer.getContainerByServiceName("albummanager"));
    }

}
