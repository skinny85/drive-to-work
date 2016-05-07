package org.skinny.drive_to_work;

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.time.LocalDate

data class Episode(val id: Int, val title: String,
                   @field:JsonSerialize(using = LocalDateSerializer::class) val releaseDate: LocalDate,
                   val description: String, val url: String) {
    private constructor() : this(0, "", LocalDate.of(2016, 2, 29), "", "")
}
