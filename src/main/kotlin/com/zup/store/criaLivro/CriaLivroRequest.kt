package com.zup.store.criaLivro

import com.zup.store.Livro
import java.util.*

class CriaLivroRequest(
    val nome: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Float
) {
    fun toModel(): Livro {
        return Livro(
            UUID.randomUUID(),
            nome,
            numero_de_paginas,
            isbn,
            preco
        )
    }

}
