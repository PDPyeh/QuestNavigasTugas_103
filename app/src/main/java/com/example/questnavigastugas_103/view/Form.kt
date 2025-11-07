package com.example.questnavigastugas_103.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun FormPendaftaran(
    onSukses: (Peserta) -> Unit,
    onBatal: () -> Unit,
    onBack: () -> Unit
){
    var nama by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var jk by rememberSaveable { mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    val valid = nama.isNotBlank() && jk.isNotBlank() && status.isNotBlank() && alamat.isNotBlank()
}