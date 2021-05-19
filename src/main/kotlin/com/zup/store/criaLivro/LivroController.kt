package com.zup.store.criaLivro

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*
import java.util.*


@Controller("api/livros")
class LivroController(private val service: TakeBookImpl) {

    @Post("/cadastro")
    @Produces(APPLICATION_JSON)
    fun createLivro(@Body request: CriaLivroRequest): HttpResponse<Any> {
        val book = request.toModel()
        val livroCadastrado = service.createBook(book);
        return HttpResponse.ok(livroCadastrado)
    }

    @Get
    fun buscaTodosOsLivros(): HttpResponse<Any> {
        val livros = service.buscaLivros()
        return HttpResponse.ok(livros)

    }

    @Get("/livros/{id}")
    fun buscaLivroPorId(id: UUID): HttpResponse<Any> {
        val livro = service.buscaLivroPorId(id)
        return HttpResponse.ok(livro)
    }


}