package com.zup.store.buscaLivro

import com.datastax.oss.driver.api.core.CqlSession
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject


@Controller("api/livros")
class buscaLivroController(@Inject private val session: CqlSession) {

    @Get("/")
    fun buscaLivro(): HttpResponse<List<Any>> {
        val livros = session.execute("SELECT * FROM LIVRO").toList()

        return HttpResponse.ok(livros)


    }

}