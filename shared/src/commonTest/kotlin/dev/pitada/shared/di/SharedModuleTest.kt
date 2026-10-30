package dev.pitada.shared.di

import app.cash.sqldelight.db.SqlDriver
import dev.pitada.shared.data.RecipeRepository
import dev.pitada.shared.data.inMemoryDriver
import kotlin.test.Test
import kotlin.test.assertEquals
import org.koin.dsl.koinApplication
import org.koin.dsl.module

class SharedModuleTest {

    @Test
    fun resolvesRepositoryFromSharedModule() {
        val testPlatform = module { single<SqlDriver> { inMemoryDriver() } }
        val koin = koinApplication { modules(testPlatform, sharedModule) }.koin

        try {
            assertEquals(0, koin.get<RecipeRepository>().count())
        } finally {
            koin.get<SqlDriver>().close()
            koin.close()
        }
    }
}
