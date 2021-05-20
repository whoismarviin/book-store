package com.zup.store.livroData.infraestrutura.subscribe

import com.zup.store.Livro
import com.zup.store.livroData.database.TakeBookData
import com.zup.store.livroData.database.TakeBookImpl
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class LivroListener(private val service: TakeBookData) {

    @Subject("livros")
    fun reiceved(livro: Livro) {
        service.createBook(livro);
    }
}