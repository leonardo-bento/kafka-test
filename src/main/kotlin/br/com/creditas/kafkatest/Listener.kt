package br.com.creditas.kafkatest

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Listener {
    @KafkaListener(topics = ["creditas.snowplow.bento.teste_v1"])
    fun listen(message: ConsumerRecord<String, Message>) {
        println("Mensagem recebida: ${message}")
    }
}