package org.skinny.drive_to_work;

import org.springframework.hateoas.RelProvider

class EpisodeRelProvider : RelProvider {
    override fun supports(type: Class<*>) = type == EpisodeEntity::class.java
    override fun getItemResourceRelFor(type: Class<*>) = "episode"
    override fun getCollectionResourceRelFor(type: Class<*>) = "episodes"
}
