package dev.pitada.shared.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import dev.pitada.shared.db.PitadaDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun create(): SqlDriver =
        AndroidSqliteDriver(PitadaDatabase.Schema, context, DATABASE_NAME)
}
