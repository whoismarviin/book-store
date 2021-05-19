package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.zup.store.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
class TakeBookImpl(private val session: CqlSession) : TakeBookData {
    override fun createBook(livro: Livro): Livro {
        val livroCadastrado = Livro(livro.id, livro.nome, livro.numero_de_paginas, livro.isbn, livro.preco)
        session.execute(
            SimpleStatement.newInstance(
                "INSERT INTO book.Livro(id,nome,numero_de_paginas,isbn,preco) VALUES (?,?,?,?,?)",
                livroCadastrado.id,
                livroCadastrado.nome,
                livroCadastrado.numero_de_paginas,
                livroCadastrado.isbn,
                livroCadastrado.preco

            )
        )

        return livroCadastrado

    }


    override fun buscaLivros(): MutableList<Livro> {
        val rows = session.execute("SELECT * FROM Livro").toList()
        val livros: MutableList<Livro> = mutableListOf()
        for (row in rows) {
            val id = row.getUuid(CqlIdentifier.fromCql("id"))!!
            val nome = row.getString(CqlIdentifier.fromCql("nome"))!!
            val nP = row.getString(CqlIdentifier.fromCql("numero_de_paginas"))!!
            val isbn = row.getString(CqlIdentifier.fromCql("isbn"))!!
            val preco = row.getFloat(CqlIdentifier.fromCql("preco"))!!
            livros.add(
                Livro(
                    id,
                    nome,
                    nP,
                    isbn,
                    preco
                )
            )

        }

        return livros

    }


    override fun buscaLivroPorId(id: UUID): Any {
        val row = session.execute("SELECT * FROM LIVRO WHERE id = ?", id)
        return row.map {
            it.getUuid(CqlIdentifier.fromCql("id"))
            it.getString(CqlIdentifier.fromCql("nome"))
            it.getString(CqlIdentifier.fromCql("numero_de_paginas"))
            it.getString(CqlIdentifier.fromCql("isbn"))
            it.getFloat(CqlIdentifier.fromCql("preco"))
        }
    }
}
