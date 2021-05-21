package com.zup.store.livroData.controller

import com.zup.store.Livro
import com.zup.store.livroData.database.TakeBookImpl
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import javax.inject.Inject

@MicronautTest
internal class LivroControllerTest {
    @field:Inject
    lateinit var service: TakeBookImpl


    @Test
    fun deveriaCadastrarUmLivro() {
        val livro = service.createBook(
            Livro(
                UUID.randomUUID(), "O triste fim ",
                "119",
                "99282933",
                19.9F
            )
        )

        assertNotNull(livro.id)
        assertNotNull(livro.nome)
        assertNotNull(livro.numero_de_paginas)
        assertNotNull(livro.isbn)
        assertNotNull(livro.preco)

    }


    @Test
    fun deveriaBuscarTodosOsLivros() {
        val livros = service.buscaLivros();

        assertNotNull(livros)

    }


}