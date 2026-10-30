package dev.pitada.app

import androidx.compose.ui.window.ComposeUIViewController
import dev.pitada.shared.di.initKoin

fun MainViewController() = ComposeUIViewController { App() }

/** Called once from the iOS app entry point before any UI is shown. */
fun doInitKoin() {
    initKoin()
}
