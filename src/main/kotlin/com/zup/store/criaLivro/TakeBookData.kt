package com.zup.store.criaLivro

import com.zup.store.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface TakeBookData {
    fun createBook(livro: Livro): Livro
    fun buscaLivros(): List<Any>
//    fun buscaLivroPorId(id: UUID): Any
}
