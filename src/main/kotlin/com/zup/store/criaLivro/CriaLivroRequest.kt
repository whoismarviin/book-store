package com.zup.store.criaLivro

import com.zup.store.Livro

class CriaLivroRequest(
    val nome: String,
    val numero_de_paginas: String,
    val isbn: String,
    val preco: Float
) {
    fun toModel(): Livro {
        return Livro(
            nome,
            numero_de_paginas,
            isbn,
            preco
        )
    }

}
