package org.skinny.drive_to_work;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.EntityLinks
import org.springframework.hateoas.ExposesResourceFor
import org.springframework.hateoas.PagedResources
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dtw/api/episodes")
@ExposesResourceFor(Episode::class)
class EpisodeController @Autowired constructor(
        val episodeRepository: EpisodeRepository,
        val entityLinks: EntityLinks) {
    @RequestMapping(method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun episodes(@RequestParam("page", defaultValue = "0") page: Int,
                 @RequestParam("limit", defaultValue = "25") limit: Int): HttpEntity<PagedResources<Episode>> {
        val episodes = episodeRepository.episodes()
        val pageMetadata = PagedResources.PageMetadata(episodes.size.toLong(), page.toLong(), 50)
        val resources = PagedResources<Episode>(episodes, pageMetadata)
        resources.add(entityLinks.linkToCollectionResource(Episode::class.java))
        return ResponseEntity(resources, HttpStatus.OK)
    }
}
