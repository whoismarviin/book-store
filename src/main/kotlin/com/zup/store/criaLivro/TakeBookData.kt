package com.zup.store.criaLivro

import com.zup.store.Livro
import javax.inject.Singleton

@Singleton
interface TakeBookData {
    fun createBook(livro: Livro): Livro
}