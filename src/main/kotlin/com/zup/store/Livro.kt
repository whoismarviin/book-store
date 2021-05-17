package com.zup.store

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Introspected
@Entity
class Livro(
    val nome: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Float
) {
    @Id
    @GeneratedValue
    val id: UUID? = null

}
