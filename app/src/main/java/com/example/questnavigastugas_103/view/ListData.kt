package com.example.questnavigastugas_103.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.questnavigastugas_103.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListData(
    items: List<Peserta>,
    toBeranda: () -> Unit,
    toForm: () -> Unit
){
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.list_title)) }) }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f, false)
            ) {
                items(items) { p ->
                    ElevatedCard {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                stringResource(R.string.nama_lengkap),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(p.nama)
                            Spacer(Modifier.height(6.dp))
                            Text(
                                stringResource(R.string.jenis_kelamin),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(p.jk)
                            Spacer(Modifier.height(6.dp))
                            Text(
                                stringResource(R.string.status_perkawinan),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(p.status)
                            Spacer(Modifier.height(6.dp))
                            Text(stringResource(R.string.alamat), fontWeight = FontWeight.SemiBold)
                            Text(p.alamat)
                        }
                    }
                }
            }
            Button(
                onClick = toBeranda,
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) { Text(stringResource(R.string.beranda)) }
            OutlinedButton(
                onClick = toForm,
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) { Text(stringResource(R.string.form_isian)) }
        }
    }
}