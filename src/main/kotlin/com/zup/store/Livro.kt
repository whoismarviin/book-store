package com.zup.store

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Introspected
class Livro(
    val nome: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Float
) {
    val id: UUID? = null

}
