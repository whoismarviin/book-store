package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.zup.store.Livro
import javax.inject.Singleton

@Singleton
class takeBookImpl(private val session: CqlSession) : TakeBookData {
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


    override fun buscaLivros(rows: List<Row>): MutableList<Livro> {
        val livros: MutableList<Livro> = mutableListOf()
        for (row in rows) {
            val id = row.getUuid(CqlIdentifier.fromCql("id"))!!
            val nome = row.getString(CqlIdentifier.fromCql("nome"))!!
            val nP = row.getString(CqlIdentifier.fromCql("numero_de_paginas"))!!
            val isbn = row.getString(CqlIdentifier.fromCql("isbn"))!!
            val preco = row.getFloat(CqlIdentifier.fromCql("preco"))!!
            livros.add(
                id,
                nome,
                nP,
                isbn,
                preco
            )
        }

        return livros

    }
//
//    override fun buscaLivroPorId(id: UUID): Any {
//        val livroASerEncontrado = session.execute(
//            "SELECT * FROM LIVRO WHERE id = ?",
//            id
//        )
//        return livroASerEncontrado;
//
//    }
}