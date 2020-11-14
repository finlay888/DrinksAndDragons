package uk.co.nightowl.platforms.drinksdragons.models

data class Outcome (
    val treasure : Int = 0,
    val level : Int = 0,
    val special : Treasure?,
    val statType : String = "",
    val statEffect : Int = 0,
    val Description : String = ""
)