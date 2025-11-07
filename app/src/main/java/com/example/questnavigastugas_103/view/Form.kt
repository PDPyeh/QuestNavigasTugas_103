
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.questnavigastugas_103.R

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
            SmallTopAppBar(
                title = { Text(stringResource(R.string.form_title)) },
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
        }
    }
}

@Composable
fun RadioRow(options: List<String>, selected: String, onSelect: () -> Unit) {
    TODO("Not yet implemented")
}
