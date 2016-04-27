package org.skinny.drive_to_work;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDate

@SpringBootApplication
open class Application : RepositoryRestConfigurerAdapter() {
    @Override
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        config.exposeIdsFor(EpisodeEntity::class.java)
    }

    @Bean
    open fun jacksonBuilder(): Jackson2ObjectMapperBuilder {
        val builder: Jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilder();
        builder.serializerByType(LocalDate::class.java, LocalDateSerializer());
        return builder;
    }

    @Bean
    open fun episodeRepository(): EpisodeRepository {
        return EpisodeRepository()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args);
        }
    }
}
