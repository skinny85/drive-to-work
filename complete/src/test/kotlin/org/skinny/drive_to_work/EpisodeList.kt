package org.skinny.drive_to_work

data class EpisodeList(val episodes: List<Episode>) {
    constructor() : this(emptyList())
}
