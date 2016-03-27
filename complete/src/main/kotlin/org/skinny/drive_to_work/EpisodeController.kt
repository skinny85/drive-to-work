package org.skinny.drive_to_work;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate

@RestController
@RequestMapping("/dtw/api/episodes")
class EpisodeController {
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun episodes(): List<Episode> = episodes

    companion object {
        val episodes = listOf(
                Episode(307, "Limited Edition, Part 1", LocalDate.of(2016, 2, 19),
                        "Mark begins a new six-part series on the design of Limited Edition (Alpha), Limited Edition (Beta), and Unlimited Edition",
                        "http://media.wizards.com/2016/podcasts/magic/drivetowork307_limitededitionpart1.mp3"),
                Episode(306, "Chris Rush", LocalDate.of(2016, 2, 19),
                        "Mark remembers the life of Christopher Rush and shares stories about their interactions",
                        "http://media.wizards.com/2016/podcasts/magic/drivetowork306_chrisrush.mp3"),
                Episode(305, "Reprints", LocalDate.of(2016, 2, 12),
                        "Mark talks about how and when Research and Development decide to use reprints in a design",
                        "http://media.wizards.com/2016/podcasts/magic/drivetowork305_reprints.mp3"),
                Episode(304, "Firsts, Part 2", LocalDate.of(2016, 2, 12),
                        "Mark concludes his two-part discussion with Melissa DeTora on their Magic firsts",
                        "http://media.wizards.com/2016/podcasts/magic/drivetowork304_firstspart2.mp3"),
                Episode(303, "Firsts, Part 1", LocalDate.of(2016, 2, 5),
                        " Mark is joined by Melissa DeTora for a two-parter where they discuss their Magic firsts",
                        "http://media.wizards.com/2016/podcasts/magic/drivetowork303_firstspart1.mp3")
        )
    }
}
