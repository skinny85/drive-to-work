package org.skinny.drive_to_work;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dtw/api/episodes")
class EpisodeController @Autowired constructor(
        val episodeRepository: EpisodeRepository) {
    @RequestMapping(method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun episodes(@PageableDefault(size = 25) pageable: Pageable, assembler: PagedResourcesAssembler<Episode>):
            HttpEntity<PagedResources<Resource<Episode>>> {
        val episodes = episodeRepository.episodes(pageable.pageNumber, pageable.pageSize)
        val page: Page<Episode> = PageImpl(episodes.episodes, pageable, episodes.total.toLong())
        return ResponseEntity(assembler.toResource(page), HttpStatus.OK)
    }
}
