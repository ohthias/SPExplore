package com.example.spexplore.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.spexplore.AppScreen
import com.example.spexplore.R
import com.example.spexplore.data.DataLocal
import com.example.spexplore.data.dataLocal
import com.example.spexplore.opcoes

@Composable
fun HomeLayout(navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ){
        items(dataLocal) {
            ButtonCard(it, navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ButtonCard(
    dataLocal : DataLocal,
    navController: NavController,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = modifier
               .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Image(
                painter = painterResource(dataLocal.idDrawableResLocal),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        bottom = 8.dp,
                        end = 16.dp,
                        top = 8.dp
                    )
            ) {
                Text(
                    text = stringResource(dataLocal.idStringLocal),
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 16.sp
                )
                IconButton(
                    onClick = {
                        if(dataLocal.idStringLocal == R.string.cultura) {
                            opcoes = 1
                        }else if(dataLocal.idStringLocal == R.string.lazer) {
                            opcoes = 2
                        }else {
                            opcoes = 3
                        }

                        navController.navigate(AppScreen.Selected.name)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = modifier.size(16.dp)
                    )
                }
            }
        }
    }
}