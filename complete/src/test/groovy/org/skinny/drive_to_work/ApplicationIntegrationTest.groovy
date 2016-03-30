package org.skinny.drive_to_work

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.LocalDate

@ContextConfiguration(loader = SpringApplicationContextLoader.class,
        classes = [Application.class])
@WebIntegrationTest(randomPort = true)
class ApplicationIntegrationTest extends Specification {
    @Value('${local.server.port}')
    int port

    def restTemplate = new TestRestTemplate()

    def "GET /dtw/api/episodes"() {
        when:
        def response = restTemplate.getForEntity("http://localhost:$port/dtw/api/episodes", EpisodeList)
        EpisodeList responseBody = response.body
        List<Episode> episodeList = responseBody.episodes

        then:
        response.statusCode == HttpStatus.OK
        episodeList.size() == 50
        Episode lastEpisode = episodeList.get(0)
        lastEpisode.releaseDate == LocalDate.of(2016, 3, 25)
    }
}
