package org.skinny.drive_to_work

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek

class ExampleSpec : Spek() { init {
    given("an empty String Builder") {
        val sb = StringBuilder()

        on("adding a character to the builder") {
            sb.append('c')

            it("should not be empty") {
                assertThat(sb).isNotEmpty()
            }

            it("should contain that character") {
                assertThat(sb).contains("c")
            }
        }
    }
}}
