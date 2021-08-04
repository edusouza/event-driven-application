package br.com.eduardosouza.applicationA.controller

import com.google.cloud.spring.pubsub.PubSubAdmin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/pubsub")
class PubSubAdminController(private val pubSubAdmin: PubSubAdmin) {

    @PostMapping
    @RequestMapping("/create/{topicName}")
    fun createTopic(@PathVariable("topicName") topicName: String) {

        val topic = pubSubAdmin.getTopic(topicName)
        if (topic == null) {
            pubSubAdmin.createTopic(topicName)
        }
    }
}