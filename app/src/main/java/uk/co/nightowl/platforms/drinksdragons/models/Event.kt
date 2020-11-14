package uk.co.nightowl.platforms.drinksdragons.models

import android.graphics.drawable.Drawable

data class Event (
    val name : String = "",
    val image : Int,
    val description : String = "",
    val bsDescription : String = "",
    val badStuff : BadStuff?,
    val special : SpecialEvent?,
    val treasure : Int = 0,
    val charm : String = "",
    val fight : String = "",
    val fDifficulty : Int = 40,
    val cDifficulty : Int = 40,
    val rDifficulty : Int = 40,
    val curse : Curse? = null
)