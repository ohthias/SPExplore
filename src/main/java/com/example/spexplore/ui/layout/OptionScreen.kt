package com.example.spexplore.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spexplore.R
import com.example.spexplore.data.DataOpcoes

@Composable
fun OptionScreen(dataOpcoes: DataOpcoes, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(dataOpcoes.idStringOpcoes),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = modifier.height(32.dp))
        ImagemOption(dataOpcoes)
        Spacer(modifier = modifier.height(32.dp))
        Avaliacao(dataOpcoes)
        Spacer(modifier = modifier.height(16.dp))
        Descricao(dataOpcoes)
    }
}

@Composable
fun ImagemOption(dataOpcoes: DataOpcoes, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(dataOpcoes.idDrawableResOpcoes),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun Avaliacao(dataOpcoes: DataOpcoes, modifier: Modifier = Modifier) {
    Row (
      verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..5) {
            Icon(
                imageVector = Icons.Filled.StarBorder,
                contentDescription = null,
                modifier = modifier
                    .size(24.dp),
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
        Spacer(modifier = modifier.width(16.dp))
        Text (
            text = dataOpcoes.avalicao.toString(),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun Descricao(dataOpcoes: DataOpcoes, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
            .padding(8.dp)
            .clip(MaterialTheme.shapes.large)
    ) {
        Text(
            text = stringResource(dataOpcoes.idStringOpcoesDescricao),
            textAlign = TextAlign.Left,
            fontSize = 14.sp,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}