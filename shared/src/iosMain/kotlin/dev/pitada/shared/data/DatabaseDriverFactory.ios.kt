package dev.pitada.shared.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import dev.pitada.shared.db.PitadaDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver = NativeSqliteDriver(PitadaDatabase.Schema, DATABASE_NAME)
}
