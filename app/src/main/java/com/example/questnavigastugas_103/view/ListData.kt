package com.example.questnavigastugas_103.view

import androidx.compose.runtime.Composable

@Composable
fun ListData(
    items: List<Peserta>,
    toBeranda: () -> Unit,
    toForm: () -> Unit
){
    Scaffold(
        topBar = { SmallTopAppBar(title = { Text(stringResource(R.string.list_title)) }) }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
}