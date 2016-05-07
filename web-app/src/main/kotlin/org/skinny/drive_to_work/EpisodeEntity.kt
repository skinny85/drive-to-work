package org.skinny.drive_to_work;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "Episode")
open class EpisodeEntity(@field:Id val id: Long,
                         val title: String,
                         @field:JsonDeserialize(using = LocalDateDeserializer::class)
                         @field:JsonSerialize(using = LocalDateSerializer::class)
                         val releaseDate: LocalDate,
                         val description: String,
                         val url: String) {
    private constructor() : this(0, "", LocalDate.of(2016, 5, 5), "", "")

    override fun toString(): String {
        return "Episode(id=$id,title='$title',releaseDate=$releaseDate,description='$description',url='$url')"
    }
}
