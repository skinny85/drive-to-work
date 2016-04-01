package org.skinny.drive_to_work

data class EpisodeList(val episodeList: List<Episode>) {
    constructor() : this(emptyList())
}
