package com.zup.store.livroData.database

import com.zup.store.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface TakeBookData {
    fun createBook(livro: Livro): Livro
    fun buscaLivros(): MutableList<Livro>
    fun buscaLivroPorId(id: UUID): Any
    fun deletaLivroPorId(id: UUID)
}
