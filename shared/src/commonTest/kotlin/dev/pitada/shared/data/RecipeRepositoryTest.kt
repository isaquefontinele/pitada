package dev.pitada.shared.data

import app.cash.sqldelight.db.SqlDriver
import dev.pitada.shared.db.PitadaDatabase
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

/** In-memory driver with [PitadaDatabase.Schema] already created. */
expect fun inMemoryDriver(): SqlDriver

class RecipeRepositoryTest {

    private val driver = inMemoryDriver()
    private val repository = RecipeRepository(PitadaDatabase(driver))

    @AfterTest
    fun tearDown() = driver.close()

    @Test
    fun startsEmpty() {
        assertEquals(0, repository.count())
    }

    @Test
    fun returnsRecipesSortedByNameIgnoringCase() {
        repository.add("pão de queijo", 20)
        repository.add("Bolo de cenoura", 8)

        val names = repository.all().map { it.name }

        assertEquals(listOf("Bolo de cenoura", "pão de queijo"), names)
    }

    @Test
    fun keepsServings() {
        repository.add("Brigadeiro", 30)

        assertEquals(30, repository.all().single().servings)
    }
}
