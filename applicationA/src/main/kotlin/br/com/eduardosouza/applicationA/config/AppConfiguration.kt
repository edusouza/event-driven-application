package br.com.eduardosouza.applicationA.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter
import com.google.cloud.spring.pubsub.support.converter.PubSubMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    fun pubSubMessageConverter(): PubSubMessageConverter {
        return JacksonPubSubMessageConverter(ObjectMapper())
    }
}