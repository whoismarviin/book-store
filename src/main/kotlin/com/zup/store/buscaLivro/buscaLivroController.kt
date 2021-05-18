package com.zup.store.buscaLivro

import com.datastax.oss.driver.api.core.CqlSession
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*
import java.util.*
import javax.inject.Inject


@Controller("api/livros")
class buscaLivroController(@Inject private val session: CqlSession) {

    @Get("/")
    @Produces(APPLICATION_JSON)
    fun buscaLivro(): HttpResponse<List<Any>> {
        val livros = session.execute("SELECT * FROM LIVRO").toList()

        return HttpResponse.ok(livros)


    }

    @Get("/id")
    @Produces(APPLICATION_JSON)
    fun buscaLivroPorAutor(@PathVariable id: UUID): HttpResponse<Any> {
        val livro = session.execute("SELECT * FROM book.LIVRO WHERE Livro.id = id", id)

        return HttpResponse.ok(livro)
    }


}