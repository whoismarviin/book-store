package com.zup.store

import io.micronaut.core.annotation.Introspected
import java.util.*


@Introspected
class Livro(
    val id: UUID,
    val nome: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Float
) {

}
