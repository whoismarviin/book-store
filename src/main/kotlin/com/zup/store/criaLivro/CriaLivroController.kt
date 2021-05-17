package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.zup.store.Livro
import io.micronaut.http.annotation.Controller
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Post
import javax.inject.Inject


@Controller("api/livros")
class CriaLivroController(@Inject val cliente: CqlSession) {

    @Post("/cadastro")
    fun createLivro(livro: Livro, request: CriaLivroRequest): HttpResponse<Any> {
        val book = request.toModel()
        val livroCadastrado = cliente.execute(
            SimpleStatement.newInstance(
                "INSERT INTO livro.Livro(id,nome,numero_de_paginas,isbn,preco) VALUES (?,?,?,?,?)",
                book.id,
                book.nome,
                book.numero_de_paginas,
                book.isbn,
                book.preco

            )
        )

        return HttpResponse.ok(livroCadastrado)

    }

}