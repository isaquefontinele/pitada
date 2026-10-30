package dev.pitada.shared.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.inMemoryDriver
import dev.pitada.shared.db.PitadaDatabase

actual fun inMemoryDriver(): SqlDriver = inMemoryDriver(PitadaDatabase.Schema)
