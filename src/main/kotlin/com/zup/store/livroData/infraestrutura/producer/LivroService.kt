package com.zup.store.livroData.infraestrutura.producer

import com.zup.store.Livro
import javax.inject.Singleton

@Singleton
interface LivroService {
    fun send(livro: Livro): Livro
}