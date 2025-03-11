package edu.unimagdalena.talleraerolineas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.TestcontainersExtension;
import org.testcontainers.utility.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoCO
@SpringBootTest
class TallerAerolineasApplicationTests {

    @Test
    void contextLoads() {
    }

}
