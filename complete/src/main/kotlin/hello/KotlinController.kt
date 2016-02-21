package hello

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinController {
    @RequestMapping("/kotlin")
    fun index(): String = "Hello World"
}
