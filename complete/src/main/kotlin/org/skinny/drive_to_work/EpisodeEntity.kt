package org.skinny.drive_to_work;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Episode")
open class EpisodeEntity(@field:Id val id: Long,
                              val title: String,
                              val description: String,
                              val url: String) {
    private constructor() : this(0, "", "", "")
}
