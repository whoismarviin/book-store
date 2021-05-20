package com.zup.store.livroData.infraestrutura.producer

import com.zup.store.Livro
import com.zup.store.livroData.infraestrutura.LivroClient
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(private val cliente: LivroClient) : LivroService {
    override fun send(livro: Livro): Livro {
        return cliente.send(livro)
    }
}