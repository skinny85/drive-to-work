package org.skinny.drive_to_work

data class EpisodeList(val episodeEntities: List<EpisodeEntity>) {
    constructor() : this(emptyList())
}
