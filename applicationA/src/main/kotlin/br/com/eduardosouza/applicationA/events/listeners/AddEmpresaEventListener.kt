package br.com.eduardosouza.applicationA.events.listeners

import br.com.eduardosouza.applicationA.config.EventsConfigurationProperties
import com.google.cloud.spring.data.datastore.core.mapping.event.AfterSaveEvent
import com.google.cloud.spring.pubsub.core.PubSubTemplate
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class AddEmpresaEventListener(
    private val pubSubTemplate: PubSubTemplate,
    private val properties: EventsConfigurationProperties
) : ApplicationListener<AfterSaveEvent>{

    override fun onApplicationEvent(event: AfterSaveEvent) {
        val source = event.source

        logger.info("Entity added: $source")

        pubSubTemplate.publish(properties.company.pubsub.topic, source, createAttributes())

        logger.info("Message published.")
    }

    private fun createAttributes() =
        mapOf(
            Pair("deleted", "false"),
            Pair("clock", System.currentTimeMillis().toString())
        )

    companion object {
        val logger = LoggerFactory.getLogger(AddEmpresaEventListener::class.java)
    }

}