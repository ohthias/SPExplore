package com.example.spexplore.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spexplore.AppScreen
import com.example.spexplore.data.DataOpcoes
import com.example.spexplore.data.listaCultura
import com.example.spexplore.data.listaLazer
import com.example.spexplore.data.listaRestaurante
import com.example.spexplore.indexOpcao

@Composable
fun SelectedScreen(
    opcao : Int,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        val lista = when (opcao) {
            1 -> listaCultura
            2 -> listaLazer
            else -> listaRestaurante
        }
        items(lista) {
            CardOpcoes(lista.indexOf(it),it, navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Composable
fun CardOpcoes(
    index : Int,
    dataOpcoes: DataOpcoes,
    navController: NavController,
    modifier: Modifier = Modifier
) {
 Card(
     modifier = modifier
         .fillMaxWidth()
 ) {
     Row(
         verticalAlignment = Alignment.CenterVertically,
         modifier = modifier
             .padding(10.dp)
     ) {
         Image(
             painter = painterResource(dataOpcoes.idDrawableResOpcoes),
             contentDescription = null,
             modifier = modifier
                 .size(75.dp)
                 .clip(MaterialTheme.shapes.small),
             contentScale = ContentScale.Crop
         )
         Spacer(modifier = modifier.width(16.dp))
         Text(
             text = stringResource(dataOpcoes.idStringOpcoes),
             style = MaterialTheme.typography.bodyLarge,
             modifier = modifier
                 .width(150.dp)
         )
         Spacer(modifier = modifier.weight(1f))
         IconButton(
             onClick = {
                 indexOpcao = index
                 navController.navigate(AppScreen.Option.name)
             }
         ) {
             Icon(
                 imageVector = Icons.Filled.ArrowForwardIos,
                 contentDescription = null
             )
         }
     }
 }
}