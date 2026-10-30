package dev.pitada.shared.data

import app.cash.sqldelight.db.SqlDriver

/** Creates the platform SQLite driver for [dev.pitada.shared.db.PitadaDatabase]. */
expect class DatabaseDriverFactory {
    fun create(): SqlDriver
}

internal const val DATABASE_NAME = "pitada.db"
