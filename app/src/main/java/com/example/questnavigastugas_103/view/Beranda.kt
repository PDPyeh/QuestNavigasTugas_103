package com.example.questnavigastugas_103.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigastugas_103.R
import androidx.compose.ui.graphics.Color
import com.example.questnavigastugas_103.ui.theme.BlackDeep
import com.example.questnavigastugas_103.ui.theme.GrayLight
import com.example.questnavigastugas_103.ui.theme.RedPrimary

@Composable
fun Beranda(onSubmitClick: () -> Unit) {
    Scaffold(
        containerColor = BlackDeep
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlackDeep)
                .padding(inner)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Spacer(Modifier.height(8.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(stringResource(R.string.selamat_datang), fontSize = 48.sp, fontWeight = FontWeight.SemiBold,color = Color.White)
                Spacer(Modifier.height(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.zertawwww),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape)
                )

                Spacer(Modifier.height(16.dp))
                Text(stringResource(
                    R.string.nama_mahasiswa),
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                    )
                Text(stringResource(R.string.nim), style = MaterialTheme.typography.bodySmall,color = GrayLight)
            }
            Button(
                onClick = onSubmitClick,
                shape = MaterialTheme.shapes.extraLarge,
                colors = ButtonDefaults.buttonColors(
                    containerColor = RedPrimary,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(stringResource(R.string.submit))
            }
        }
    }
}