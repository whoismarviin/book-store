package com.zup.store.criaLivro

import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.internal.core.metadata.schema.queries.CassandraSchemaRows
import com.zup.store.Livro
import java.util.*
import javax.inject.Singleton

@Singleton
interface TakeBookData {
    fun createBook(livro: Livro): Livro
    fun buscaLivros(rows: List<Row>): MutableList<Livro>
//    fun buscaLivroPorId(id: UUID): Any
}
