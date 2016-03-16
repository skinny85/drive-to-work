package org.skinny.drive_to_work;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dtw/api/episodes")
class EpisodeController {
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun episodes(): List<Episode> = listOf(
            Episode(307, "Limited Edition, Part 1",
                    "Mark begins a new six-part series on the design of Limited Edition (Alpha), Limited Edition (Beta), and Unlimited Edition",
                    "http://media.wizards.com/2016/podcasts/magic/drivetowork307_limitededitionpart1.mp3"),
            Episode(306, "Chris Rush",
                    "Mark remembers the life of Christopher Rush and shares stories about their interactions",
                    "http://media.wizards.com/2016/podcasts/magic/drivetowork306_chrisrush.mp3"),
            Episode(305, "Reprints",
                    "Mark talks about how and when Research and Development decide to use reprints in a design",
                    "http://media.wizards.com/2016/podcasts/magic/drivetowork305_reprints.mp3")
    )
}
