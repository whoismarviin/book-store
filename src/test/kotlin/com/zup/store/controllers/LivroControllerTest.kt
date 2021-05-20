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
//class LivroControllerTest(private val service: TakeBookData) : FunSpec({
//
//    test("Deve cadastrar um livro") {
//        val livro = service.createBook(
//            Livro(
//                UUID.randomUUID(),
//                "As viagens do peregrino da alvorada",
//                "110",
//                "9292929209",
//                19.9F
//            )
//        )
//
//        livro.nome.shouldBe("As Viagens do peregrino da alvorada")
//
//
//    }
//
//
//})
//
//
//
