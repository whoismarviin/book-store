package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.micronaut.http.annotation.Controller
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Controller("api/livros")
class CriaLivroController(@Inject val cliente: CqlSession) {

    @Post("/cadastro")
    @Produces(APPLICATION_JSON)
    fun createLivro(@Body request: CriaLivroRequest): HttpResponse<Any> {
        val book = request.toModel()
        val livroCadastrado = cliente.execute(
            SimpleStatement.newInstance(
                "INSERT INTO book.Livro(id,nome,numero_de_paginas,isbn,preco) VALUES (?,?,?,?,?)",
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