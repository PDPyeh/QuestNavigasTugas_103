package com.example.questnavigastugas_103

import FormPendaftaran
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigastugas_103.view.Beranda
import com.example.questnavigastugas_103.view.ListData

sealed class Screen(val route: String) {
    data object Beranda : Screen("beranda")
    data object Form : Screen("form")
    data object ListData : Screen("list")
}
data class Peserta(
    val nama: String,
    val jk: String,
    val status: String,
    val alamat: String
)

class PesertaViewModel : ViewModel() {
    val daftar = mutableStateListOf<Peserta>()
    fun tambah(p: Peserta) { daftar.add(p) }
    fun clear() { daftar.clear() }
}

@Composable
fun AppNav(
    navController: NavHostController = rememberNavController(),
    vm: PesertaViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = Screen.Beranda.route) {
        composable(Screen.Beranda.route) {
            Beranda(
                onSubmitClick = { navController.navigate(Screen.Form.route) }
            )
        }
        composable(Screen.Form.route) {
            FormPendaftaran(
                onSukses = { peserta ->
                    vm.tambah(peserta)
                    navController.navigate(Screen.ListData.route) {
                        popUpTo(Screen.Form.route) { inclusive = true }
                    }
                },
                onBatal = { /* stay */ },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Screen.ListData.route) {
            ListData(
                items = vm.daftar,
                toBeranda = { navController.navigate(Screen.Beranda.route) { popUpTo(0) } },
                toForm = { navController.navigate(Screen.Form.route) }
            )
        }
    }
}