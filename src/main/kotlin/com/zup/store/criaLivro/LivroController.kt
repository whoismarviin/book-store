package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.micronaut.http.annotation.Controller
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces


@Controller("api/livros")
class LivroController(private val service: takeBookImpl) {

    @Post("/cadastro")
    @Produces(APPLICATION_JSON)
    fun createLivro(@Body request: CriaLivroRequest): HttpResponse<Any> {
        val book = request.toModel()
        val livroCadastrado = service.createBook(book);
        return HttpResponse.ok(book)
    }

}