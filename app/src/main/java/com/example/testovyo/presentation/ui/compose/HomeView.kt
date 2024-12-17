package com.example.testovyo.presentation.ui.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testovyo.R
import com.example.testovyo.domain.model.Item
import com.example.testovyo.presentation.viewmodel.MyViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: MyViewModel
) {
    val uiState by viewModel.viewState.collectAsState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyColumn {
            items(uiState.items.size) {
                UserDetail(
                    Modifier,
                    item = uiState.items[it]
                )
            }
        }
    }
}

@Composable
fun UserDetail(
    modifier: Modifier,
    item: Item
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(0.6f)
                .padding(16.dp),
            text = item.title
        )

        AsyncImage(
            modifier = Modifier
                .weight(0.4f) // 40% width
                .height(80.dp), // Fixed height for uniformity
            model = item.urlImage,
            contentScale = ContentScale.Crop,
            contentDescription = "Translated description of what the image contains",
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
    }
}