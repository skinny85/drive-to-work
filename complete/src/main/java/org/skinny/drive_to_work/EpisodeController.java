package org.skinny.drive_to_work;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dtw/api/episodes")
public class EpisodeController {
    @RequestMapping(method = RequestMethod.GET)
    public Episode episodes() {
        return new Episode(313, "",
            "Mark concludes his six-part series on the design of Limited Edition (Alpha), Limited Edition (Beta), and Unlimited Edition",
            "http://media.wizards.com/2016/podcasts/magic/drivetowork313_limitededitionpart6.mp3");
    }
}
