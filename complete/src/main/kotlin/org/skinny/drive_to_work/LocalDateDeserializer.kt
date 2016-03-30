package org.skinny.drive_to_work

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDate

class LocalDateDeserializer : JsonDeserializer<LocalDate>() {
    @Override
    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDate =
        LocalDate.parse(parser.valueAsString)
}
