package org.skinny.drive_to_work

data class EpisodeList(val episodes: List<EpisodeEntity>) {
    constructor() : this(emptyList())
}
