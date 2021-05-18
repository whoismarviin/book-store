package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.zup.store.Livro
import io.micronaut.http.HttpResponse
import java.util.*
import javax.inject.Singleton

@Singleton
class takeBookImpl(private val session: CqlSession) : TakeBookData {
    override fun createBook(livro: Livro): Livro {
        val livroCadastrado = Livro(UUID.randomUUID(), livro.nome, livro.numero_de_paginas, livro.isbn, livro.preco)
        session.execute(
            SimpleStatement.newInstance(
                "INSERT INTO book.Livro(id,nome,numero_de_paginas,isbn,preco) VALUES (?,?,?,?,?)",
                livroCadastrado.id,
                livroCadastrado.nome,
                livroCadastrado.numero_de_paginas,
                livroCadastrado.isbn,
                livroCadastrado.preco

            )
        )

        return livroCadastrado

    }
}