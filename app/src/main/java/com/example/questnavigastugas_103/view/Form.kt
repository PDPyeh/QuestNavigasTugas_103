
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.questnavigastugas_103.Peserta
import com.example.questnavigastugas_103.R

@OptIn(ExperimentalMaterial3Api::class)
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

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.konfirmasi_data)) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("${stringResource(R.string.nama_lengkap)}: $nama")
                    Text("${stringResource(R.string.jenis_kelamin)}: $jk")
                    Text("${stringResource(R.string.status_perkawinan)}: $status")
                    Text("${stringResource(R.string.alamat)}: $alamat")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    onSukses(Peserta(nama, jk, status, alamat))
                }) { Text(stringResource(R.string.kirim)) }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false
                    onBatal()
                }) { Text(stringResource(R.string.edit_lagi)) }
            }
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.form_title)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xC30F45),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    TextButton(onClick = onBack) { Text(stringResource(R.string.back)) }
                }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column {
                Text(stringResource(R.string.nama_lengkap), fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(stringResource(R.string.placeholder_nama)) },
                    singleLine = true
                )
            }
            Column {
                Text(stringResource(R.string.jenis_kelamin), fontWeight = FontWeight.SemiBold)
                RadioRow(
                    options = listOf(
                        stringResource(R.string.laki_laki),
                        stringResource(R.string.perempuan)
                    ),
                    selected = jk,
                    onSelect = { jk = it }
                )
            }
            Column{
                Text(stringResource(R.string.status_perkawinan), fontWeight = FontWeight.SemiBold)
                RadioRow(
                    options = listOf(
                        stringResource(R.string.janda),
                        stringResource(R.string.lajang),
                        stringResource(R.string.duda)
                    ),
                    selected = status,
                    onSelect = { status = it }
                )
            }
            Column {
                Text(stringResource(R.string.alamat), fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(stringResource(R.string.placeholder_alamat)) }
                )
            }
            Button(
                enabled = valid,
                onClick = { showDialog = true },
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) { Text(stringResource(R.string.submit)) }
        }
    }
}

@Composable
private fun RadioRow(
    options: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        options.forEach { label ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selected == label, onClick = { onSelect(label) })
                Text(label)
            }
        }
    }
}


