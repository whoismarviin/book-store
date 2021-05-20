package com.zup.store.livroData.infraestrutura

import com.zup.store.Livro
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
open interface LivroClient {
    @Subject("livro")
    fun send(livro: Livro)

}