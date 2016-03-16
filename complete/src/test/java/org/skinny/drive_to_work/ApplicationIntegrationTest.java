/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
	public void home_get() throws Exception {
		ResponseEntity<String> response = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.port + "/", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello IBM Bluemix!");
	}

	@Test
	public void object_get() {
		ResponseEntity<SomeObject> response =
				new TestRestTemplate()
						.getForEntity("http://localhost:" + port + "/object", SomeObject.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(new SomeObject("some_value"));
	}

	@Test
	public void kotlin_get() {
		ResponseEntity<String> response =
				new TestRestTemplate()
						.getForEntity("http://localhost:" + port + "/kotlin", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello World from Kotlin!");
	}

	@Test
	public void episodes_get() {
		ResponseEntity<List> response =
				new TestRestTemplate()
						.getForEntity("http://localhost:" + port + "/dtw/api/episodes", List.class);
		List<Episode> responseBody = response.getBody();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseBody).hasSize(3);
	}
}
