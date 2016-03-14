package org.skinny.drive_to_work

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinController {
    @RequestMapping("/kotlin")
    fun index(): String = "Hello World from Kotlin!"
}
