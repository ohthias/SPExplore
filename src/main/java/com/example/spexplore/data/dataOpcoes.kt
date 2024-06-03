package com.example.spexplore.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.spexplore.R


data class DataOpcoes(
    @StringRes val idStringOpcoes : Int,
    @DrawableRes val idDrawableResOpcoes: Int,
    @StringRes val idStringOpcoesDescricao : Int,
    val avalicao : Double
)

val listaCultura = listOf(
    DataOpcoes(R.string.pinacoteca, R.drawable.pinacoteca, R.string.pinacoteca_description, 4.5),
    DataOpcoes(R.string.museu_do_ipiranga, R.drawable.museuipiranga, R.string.museu_do_ipiranga_description, 5.0),
    DataOpcoes(R.string.masp, R.drawable.masp, R.string.masp_description, 5.0),
    DataOpcoes(R.string.museu_das_favelas, R.drawable.museufavela, R.string.museu_das_favelas_description, 4.0)
)


val listaLazer = listOf(
    DataOpcoes(R.string.parque_ibirapuera, R.drawable.ibirapuera, R.string.parque_ibirapuera_description, 4.0),
    DataOpcoes(R.string.beco_do_batman, R.drawable.becobatman, R.string.beco_do_batman_description, 4.0),
    DataOpcoes(R.string.avenida_paulista, R.drawable.avpaulista, R.string.avenida_paulista_description, 4.2),
    DataOpcoes(R.string.theatro_municipal, R.drawable.tmsp, R.string.theatro_municipal_description, 4.5)
)

val listaRestaurante = listOf(
    DataOpcoes(R.string.di_paolo, R.drawable.dipaolo, R.string.di_paolo_description, 5.0),
    DataOpcoes(R.string.mania_de_churrasco, R.drawable.maniachurrasco, R.string.mania_de_churrasco_description, 5.0),
    DataOpcoes(R.string.noah_gastronomia, R.drawable.noahgastronomia, R.string.noah_gastronomia_description, 5.0),
    DataOpcoes(R.string.cipo_resto, R.drawable.ciporesto, R.string.cipo_resto_description, 5.0)
)

