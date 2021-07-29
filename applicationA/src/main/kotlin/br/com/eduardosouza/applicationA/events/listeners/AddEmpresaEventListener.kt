package br.com.eduardosouza.applicationA.events.listeners

import com.google.cloud.spring.data.datastore.core.mapping.event.AfterSaveEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class AddEmpresaEventListener : ApplicationListener<AfterSaveEvent>{

    override fun onApplicationEvent(event: AfterSaveEvent) {
        val source = event.source

        logger.info("Entity added: $source")
    }

    companion object {
        val logger = LoggerFactory.getLogger(AddEmpresaEventListener::class.java)
    }

}