package org.skinny.drive_to_work;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.mapping.RepositoryResourceMappings
import org.springframework.data.rest.core.mapping.ResourceMappings
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDate

@SpringBootApplication
open class Application : RepositoryRestMvcConfiguration() {
    @Override
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        config.exposeIdsFor(EpisodeEntity::class.java)
    }

    @Bean
    open fun episodeRepository(): EpisodeRepository {
        return EpisodeRepository()
    }

    @Override
    override fun resourceMappings(): ResourceMappings {
        return RepositoryResourceMappings(repositories(), persistentEntities(),
                EpisodeRelProvider())
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args);
        }
    }
}
