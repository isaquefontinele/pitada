package dev.pitada.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.pitada.shared.data.RecipeRepository
import org.koin.compose.koinInject

@Composable
fun App() {
    MaterialTheme {
        Scaffold { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
private fun HomeScreen(modifier: Modifier = Modifier) {
    val repository = koinInject<RecipeRepository>()
    val recipeCount = remember { repository.count() }

    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Pitada", style = MaterialTheme.typography.headlineLarge)
        Text("Receitas salvas: $recipeCount", style = MaterialTheme.typography.bodyLarge)
    }
}
