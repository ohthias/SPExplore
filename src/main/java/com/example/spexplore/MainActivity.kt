package com.example.spexplore

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spexplore.data.listaCultura
import com.example.spexplore.data.listaLazer
import com.example.spexplore.data.listaRestaurante
import com.example.spexplore.ui.layout.HomeLayout
import com.example.spexplore.ui.layout.OptionScreen
import com.example.spexplore.ui.layout.SelectedScreen
import com.example.spexplore.ui.layout.StartScreen

enum class AppScreen(){
    Start,
    Home,
    Selected,
    Option
}

var opcoes = 1
var indexOpcao = 0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text= stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineMedium
            )},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        contentDescription = null
                    )
                }
            }
        }
    )
}


@Composable
fun SPExploreApp(
    navController: NavHostController = rememberNavController(),
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Home.name
    )
    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {it ->
        NavHost(
            navController = navController,
            startDestination = AppScreen.Start.name,
            modifier = Modifier
                .padding(it)
        ) {
            composable(AppScreen.Start.name){
                StartScreen(navController)
            }
            composable(route = AppScreen.Home.name){
                HomeLayout(navController)
            }
            composable(AppScreen.Selected.name) {
                SelectedScreen(opcoes,navController)
            }
            composable(AppScreen.Option.name) {
                if(opcoes == 1) {
                    OptionScreen(listaCultura[indexOpcao])
                } else if (opcoes == 2) {
                    OptionScreen(listaLazer[indexOpcao])
                } else {
                    OptionScreen(listaRestaurante[indexOpcao])
                }
            }
        }
    }
}
