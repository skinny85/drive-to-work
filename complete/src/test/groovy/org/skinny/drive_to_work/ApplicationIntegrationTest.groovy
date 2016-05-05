package org.skinny.drive_to_work

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader.class,
        classes = [Application.class])
@WebIntegrationTest(randomPort = true)
@ActiveProfiles("test")
class ApplicationIntegrationTest extends Specification {
    @Value('${local.server.port}')
    int port

    def restTemplate = new TestRestTemplate()

    def "GET /dtw/api/episodes"() {
        when:
        def response = restTemplate.getForEntity("http://localhost:$port/dtw/api/episodes", EpisodesResource)
        List<EpisodeEntity> episodeList = response.body._embedded.episodes

        then:
        response.statusCode == HttpStatus.OK
        episodeList.size() == 25
        EpisodeEntity lastEpisode = episodeList.get(0)
//        lastEpisode.releaseDate == LocalDate.of(2016, 3, 25)
        lastEpisode.title == "Lessons Learned: Theros"
        lastEpisode.id == 317
    }
}
