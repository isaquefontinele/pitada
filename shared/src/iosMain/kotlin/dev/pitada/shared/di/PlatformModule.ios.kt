package dev.pitada.shared.di

import app.cash.sqldelight.db.SqlDriver
import dev.pitada.shared.data.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single<SqlDriver> { DatabaseDriverFactory().create() }
}
