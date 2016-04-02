package org.skinny.drive_to_work

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class EpisodeRepositorySpec extends Specification {
    def episodeRepository = new EpisodeRepository()

    def "episodes(pageIndex=#pageIndex, limit=#limit).size == #expectedSize"(int pageIndex, int limit, int expectedSize) {
        expect:
        episodeRepository.episodes(pageIndex, limit).episodes.size() == expectedSize

        where:
        pageIndex | limit || expectedSize
            0     |  10   ||     10
            3     |  10   ||     10
            5     |  10   ||     0
            2     |  25   ||     0
            0     |  99   ||     25
            1     |  0    ||     0
    }

    def "episodes(#pageIndex, #limit) throws IllegalArgumentException"(int pageIndex, int limit) {
        when:
        episodeRepository.episodes(pageIndex, limit)

        then:
        thrown IllegalArgumentException

        where:
        pageIndex | limit
           -1     |  10
            0     |  -1
    }
}
