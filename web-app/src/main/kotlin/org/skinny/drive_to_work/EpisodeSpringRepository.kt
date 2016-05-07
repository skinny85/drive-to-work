package org.skinny.drive_to_work

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface EpisodeSpringRepository : PagingAndSortingRepository<EpisodeEntity, Long> {
    fun findByOrderByIdDesc(page: Pageable): Page<EpisodeEntity>
}
