package br.com.eduardosouza.applicationA.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "application.events")
data class EventsConfigurationProperties(
    var company: TypePubSubConfig = TypePubSubConfig()
)
