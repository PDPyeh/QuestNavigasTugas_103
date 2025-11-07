package com.example.questnavigastugas_103.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.questnavigastugas_103.Peserta
import com.example.questnavigastugas_103.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListData(
    items: List<Peserta>,
    toBeranda: () -> Unit,
    toForm: () -> Unit

){
    val RedPrimary = Color(0xFFDF0139)
    val BlackDeep = Color(0xFF1E1E27)
    val BlackSoft = Color(0xFF28242A)
    val GrayLight = Color(0xFFE2E2E2)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.list_title)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = RedPrimary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .background(BlackDeep)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f, false)
            ) {
                items(items) { p ->
                    ElevatedCard(
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = BlackSoft,
                            contentColor = Color.White
                        )
                    ) {
                        Column(
                            Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(stringResource(R.string.nama_lengkap), fontWeight = FontWeight.SemiBold)
                            Text(p.nama)
                            Spacer(Modifier.height(6.dp))

                            Text(stringResource(R.string.jenis_kelamin), fontWeight = FontWeight.SemiBold)
                            Text(p.jk)
                            Spacer(Modifier.height(6.dp))

                            Text(stringResource(R.string.status_perkawinan), fontWeight = FontWeight.SemiBold)
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
                colors = ButtonDefaults.buttonColors(
                    containerColor = RedPrimary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(stringResource(R.string.beranda))
            }

            OutlinedButton(
                onClick = toForm,
                shape = MaterialTheme.shapes.extraLarge,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = RedPrimary
                ),
                border = BorderStroke(1.dp, RedPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(stringResource(R.string.form_isian))
            }
        }
    }

}
