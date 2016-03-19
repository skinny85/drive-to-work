package org.skinny.drive_to_work;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
//@DirtiesContext
public class ApplicationIntegrationTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void episodes_get() {
        ResponseEntity<List> response = new TestRestTemplate()
                .getForEntity("http://localhost:" + port + "/dtw/api/episodes",
                        List.class);
        @SuppressWarnings("unchecked")
        List<Episode> responseBody = response.getBody();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseBody).hasSize(3);
    }
}
