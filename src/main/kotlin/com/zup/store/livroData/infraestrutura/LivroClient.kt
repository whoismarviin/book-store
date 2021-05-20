package com.zup.store.livroData.infraestrutura

import com.zup.store.Livro
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface LivroClient {
    @Subject("livros")
    fun send(livro: Livro)

}