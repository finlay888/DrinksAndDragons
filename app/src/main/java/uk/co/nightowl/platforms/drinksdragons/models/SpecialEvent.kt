package uk.co.nightowl.platforms.drinksdragons.models

data class SpecialEvent (
    val choice1 : String = "",
    val choice2 : String = "",
    val outcome1 : Outcome,
    val outcome2 : Outcome
)