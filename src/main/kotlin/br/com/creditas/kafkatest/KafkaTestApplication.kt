package br.com.creditas.kafkatest

import br.com.creditas.eventlib.EventPayload
import br.com.creditas.eventlib.EventPublisherTemplate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer

@SpringBootApplication
class KafkaTestApplication(val eventPublisherTemplate: EventPublisherTemplate) {
	init {
	    var timer = Timer()
		timer.schedule(5000, 5000) {
			val mapValue = mapOf<String, Any>(
					Pair("id", "Mensagem"),
					Pair("name", "Nome da Mensagem")
			)
			eventPublisherTemplate.send("creditas.snowplow.bento.teste_v1", MapEvent(mapValue))
		}
	}
}

data class MapEvent(val eventMap: Map<String, Any?>) : EventPayload {
	override fun properties(): Map<String, Any?> = eventMap
}


fun main(args: Array<String>) {
	runApplication<KafkaTestApplication>(*args)
}
