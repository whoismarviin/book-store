//package com.zup.store.criaLivro
//
//import com.datastax.oss.driver.api.core.CqlSession
//import com.datastax.oss.driver.api.core.cql.SimpleStatement
//import com.zup.store.Livro
//import io.kotest.core.spec.style.FunSpec
//import io.kotest.matchers.shouldBe
//import java.util.*
//
//
//class LivroControllerTest(private val session: CqlSession) : FunSpec({
//    test("Deve cadastrar um livro") {
//        val livro = Livro(
//            UUID.randomUUID(),
//            "As Cronicas De Narnia",
//            "117",
//            "92993309203",
//            19.9F
//        )
//        val livroCadastrado = session.execute(
//            SimpleStatement.newInstance(
//                "INSERT INTO book.Livro(id,nome,numero_de_paginas,isbn,preco) VALUES (?,?,?,?,?)",
//                livro.id,
//                livro.nome,
//                livro.numero_de_paginas,
//                livro.isbn,
//                livro.preco
//            )
//        )
//
//    }
//
//
//})
//
//
//
