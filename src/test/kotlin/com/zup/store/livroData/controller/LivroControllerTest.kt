package com.zup.store.livroData.controller

import com.zup.store.Livro
import com.zup.store.livroData.infraestrutura.LivroClient
import com.zup.store.livroData.infraestrutura.producer.LivroService
import io.kotest.core.spec.style.FunSpec
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*


@MicronautTest
class LivroControllerTest : FunSpec({
    @InjectMockKs
    lateinit var livroService: LivroService

    @MockK
    lateinit var livro: Livro
    lateinit var cliente: LivroClient

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        livro = Livro(
            id = UUID.randomUUID(),
            nome = "A viagem do peregrino da alvorada",
            numero_de_paginas = "112",
            isbn = "9229822",
            preco = 199.9F
        )
    }

    @Test
    fun `deve enviar um subscriber`() {
        every { cliente.send(any()) } returns Unit
        val result = livroService.send(livro)
        Assertions.assertEquals(livro, result)

    }


})
