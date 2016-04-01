package org.skinny.drive_to_work

data class EpisodesResource(val _embedded: EpisodeList) {
    private constructor() : this(EpisodeList())
}
