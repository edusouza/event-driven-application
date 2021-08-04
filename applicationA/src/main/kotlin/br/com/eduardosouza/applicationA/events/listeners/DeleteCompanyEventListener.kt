package br.com.eduardosouza.applicationA.events.listeners

import br.com.eduardosouza.applicationA.config.EventsConfigurationProperties
import com.google.cloud.spring.data.datastore.core.mapping.event.AfterDeleteEvent
import com.google.cloud.spring.pubsub.core.PubSubTemplate
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class DeleteCompanyEventListener(
    private val pubSubTemplate: PubSubTemplate,
    private val properties: EventsConfigurationProperties
) : ApplicationListener<AfterDeleteEvent>{

    override fun onApplicationEvent(event: AfterDeleteEvent) {
        val source = event.source

        logger.info("Entity removed: $source")

        pubSubTemplate.publish(properties.company.pubsub.topic, source, createAttributes())

        logger.info("Message published")
    }

    private fun createAttributes() =
        mapOf(
            Pair("deleted", "true"),
            Pair("clock", System.currentTimeMillis().toString())
        )

    companion object {
        val logger = LoggerFactory.getLogger(DeleteCompanyEventListener::class.java)
    }
}