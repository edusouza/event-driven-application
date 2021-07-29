package br.com.eduardosouza.applicationA.events.listeners

import com.google.cloud.spring.data.datastore.core.mapping.event.AfterSaveEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class AddEmpresaEventListener : ApplicationListener<AfterSaveEvent>{

    override fun onApplicationEvent(event: AfterSaveEvent) {
        event.datastoreEntities.forEach{
            println(it.toString())
        }
    }

}