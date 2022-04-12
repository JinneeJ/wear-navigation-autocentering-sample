package com.doist.wear.auto.centering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WearApp() }
    }
}

@Composable
private fun WearApp() {
    MaterialTheme {
        val navigation = rememberSwipeDismissableNavController()
        SwipeDismissableNavHost(
            navController = navigation,
            startDestination = "primary"
        ) {
            composable("primary") {
                PrimaryScreen(onItemClick = { navigation.navigate(route = "secondary") })
            }
            composable("secondary") {
                SecondaryScreen()
            }
        }
    }
}

@Composable
private fun PrimaryScreen(
    onItemClick: () -> Unit
) = Scaffold(
    modifier = Modifier.background(MaterialTheme.colors.background)
) {
    ScalingLazyColumn(state = rememberScalingLazyListState(initialCenterItemIndex = 0)) {
        items(100) {
            Chip(
                label = { Text(text = "Item $it") },
                onClick = onItemClick
            )
        }
    }
}

@Composable
private fun SecondaryScreen() = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background),
    contentAlignment = Alignment.Center
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = "Text"
    )
}
