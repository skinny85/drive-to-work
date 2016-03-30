package org.skinny.drive_to_work

data class EpisodeList(val episodes: List<Episode>) {
    private constructor() : this(emptyList())
}
