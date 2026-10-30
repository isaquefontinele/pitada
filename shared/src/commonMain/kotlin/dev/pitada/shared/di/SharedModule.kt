package dev.pitada.shared.di

import app.cash.sqldelight.db.SqlDriver
import dev.pitada.shared.data.RecipeRepository
import dev.pitada.shared.db.PitadaDatabase
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/** Platform bindings. Must provide a [SqlDriver] for [PitadaDatabase]. */
internal expect val platformModule: Module

val sharedModule = module {
    single { PitadaDatabase(get<SqlDriver>()) }
    single { RecipeRepository(get()) }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication = startKoin {
    appDeclaration()
    modules(platformModule, sharedModule)
}
