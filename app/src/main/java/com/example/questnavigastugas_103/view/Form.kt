
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
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
}
