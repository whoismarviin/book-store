package com.zup.store.livroData.controller

import com.zup.store.Livro
import com.zup.store.livroData.Dto.CriaLivroRequest
import com.zup.store.livroData.database.TakeBookImpl
import com.zup.store.livroData.infraestrutura.producer.LivroServiceImpl
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*
import java.util.*


@Controller("api/livros")
class LivroController(private val service: TakeBookImpl, private val livroService: LivroServiceImpl) {

    @Post("/cadastro")
    @Produces(APPLICATION_JSON)
    fun createLivro(@Body request: CriaLivroRequest): HttpResponse<Any> {
        livroService.send(
            Livro(
                UUID.randomUUID(),
                request.nome,
                request.numero_de_paginas,
                request.isbn,
                request.preco
            )
        )

        return HttpResponse.created("criado com sucesso!!")

    }

    @Get
    fun buscaTodosOsLivros(): HttpResponse<Any> {
        val livros = service.buscaLivros()
        return HttpResponse.ok(livros)

    }

    @Get("/{id}")
    fun buscaLivroPorId(id: UUID): HttpResponse<Any> {
        val livro = service.buscaLivroPorId(id)
        return HttpResponse.ok(livro)
    }

    @Delete("/{id}")
    fun deletaPorId(id: UUID): HttpResponse<Any> {
        service.deletaLivroPorId(id)
        return HttpResponse.ok("Livro Deletado com sucesso!!")

    }


}