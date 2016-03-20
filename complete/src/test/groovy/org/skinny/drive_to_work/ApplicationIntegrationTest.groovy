package org.skinny.drive_to_work

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class,
        classes = [Application.class])
@WebIntegrationTest(randomPort = true)
class ApplicationIntegrationTest extends Specification {
    @Value('${local.server.port}')
    int port

    def restTemplate = new TestRestTemplate()

    def "GET /dtw/api/episodes"() {
        when:
        def response = restTemplate.getForEntity("http://localhost:$port/dtw/api/episodes", List)
        def responseBody = response.body

        then:
        response.statusCode == HttpStatus.OK
        responseBody.size() == 3
    }
}
