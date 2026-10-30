package dev.pitada.shared.data

import dev.pitada.shared.db.PitadaDatabase
import dev.pitada.shared.db.Recipe

class RecipeRepository(private val database: PitadaDatabase) {

    fun all(): List<Recipe> = database.recipeQueries.selectAll().executeAsList()

    fun count(): Long = database.recipeQueries.count().executeAsOne()

    fun add(name: String, servings: Long) {
        database.recipeQueries.insert(name, servings)
    }
}
