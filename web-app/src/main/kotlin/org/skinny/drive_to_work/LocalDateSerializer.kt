package org.skinny.drive_to_work

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDate

class LocalDateSerializer : JsonSerializer<LocalDate>() {
    @Override
    override fun serialize(value: LocalDate, jgen: JsonGenerator, provider: SerializerProvider) {
        jgen.writeString(value.toString()); // this returns the date as "yyyy-MM-dd"
    }
}
