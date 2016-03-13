package hello

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(Application::class))
@WebAppConfiguration
@IntegrationTest("server.port=0")
@DirtiesContext
class KotlinControllerSpec : Spek() {
    @Value("\${local.server.port}")
    var port: Int = 0

    init {
//    @Test
//    fun test() {
        given("the application starts") {
            on("a GET request to /") {
                val response = RestTemplate()
                        .getForEntity("http://localhost:$port/kotlin", String::class.java)

                it("has status OK") {
                    assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
                }

                it("has body 'Hello World'") {
                    assertThat(response.body).isEqualTo("Hello Worldx")
                }
            }
        }
    }
}
