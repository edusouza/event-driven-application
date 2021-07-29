package br.com.eduardosouza.applicationA.events.listeners

import com.google.cloud.spring.data.datastore.core.mapping.event.AfterDeleteEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class DeleteEmpresaEventListener : ApplicationListener<AfterDeleteEvent>{

    override fun onApplicationEvent(event: AfterDeleteEvent) {
        val source = event.source

        logger.info("Entity removed: $source")

    }

    companion object {
        val logger = LoggerFactory.getLogger(DeleteEmpresaEventListener::class.java)
    }
}