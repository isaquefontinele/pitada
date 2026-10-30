package dev.pitada.shared.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import dev.pitada.shared.db.PitadaDatabase

actual fun inMemoryDriver(): SqlDriver =
    JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also { PitadaDatabase.Schema.create(it) }
