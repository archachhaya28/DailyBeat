package com.example.dailybeat.android.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dailybeat.Platform

@Composable
fun AboutDeviceScreen(
    onUpButtonClick: () -> Unit
) {
    Column {
        ToolBar(onUpButtonClick)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolBar(
    onUpButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text ="About Device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        }
    )
}

@Composable
private fun ContentView() {
    val items1 = makeItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items1) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@Composable
private fun RowView(
    title: String,
    subtitle: String
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }

    Divider()
}