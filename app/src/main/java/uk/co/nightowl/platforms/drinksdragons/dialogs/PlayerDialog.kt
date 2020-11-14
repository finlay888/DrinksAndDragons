package uk.co.nightowl.platforms.drinksdragons.dialogs

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.dialog_players.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.activities.MainActivity
import uk.co.nightowl.platforms.drinksdragons.models.Character
import uk.co.nightowl.platforms.drinksdragons.objects.Constants

abstract class PlayerDialog(
    context: Context,
    private val playerNum : Int
) : Dialog(context){

    private val characterArray = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = LayoutInflater.from(context).inflate(
            R.layout.dialog_players, null)

        setContentView(view)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        setUpDialog()
    }

    private fun setUpDialog(){
        if (playerNum > 1){
            et_player_name_two.visibility = View.VISIBLE
        }
        if (playerNum > 2){
            et_player_name_three.visibility = View.VISIBLE
        }
        if (playerNum > 3){
            et_player_name_four.visibility = View.VISIBLE
        }
        if (playerNum > 4){
            et_player_name_five.visibility = View.VISIBLE
        }
        if (playerNum > 5){
            et_player_name_six.visibility = View.VISIBLE
        }
        btn_names_confirm.setOnClickListener {
            createCharacterArray()
            val intent = Intent(context, MainActivity::class.java)
            intent.putParcelableArrayListExtra(Constants.PLAYERS, characterArray)
            context.startActivity(intent)
            this.dismiss()
        }
    }

    private fun createCharacterArray(){
        if (!et_player_name_one.text.isNullOrEmpty()){
            characterArray.add(Character(et_player_name_one.text.toString()))
        }else{
            characterArray.add(Character("Finlay The Ferocious"))
        }

        if (et_player_name_two.text.isNullOrEmpty() && playerNum > 1){
            characterArray.add(Character("John Of Snow"))
        }else if (playerNum > 1){
            characterArray.add(Character(et_player_name_two.text.toString()))
        }

        if (et_player_name_three.text.isNullOrEmpty() && playerNum > 2){
            characterArray.add(Character("Jack Like Sparrow"))
        }else if (playerNum > 2){
            characterArray.add(Character(et_player_name_three.text.toString()))
        }

        if (et_player_name_two.text.isNullOrEmpty() && playerNum > 3){
            characterArray.add(Character("Jamie Of Oliver"))
        }else if (playerNum > 3){
            characterArray.add(Character(et_player_name_two.text.toString()))
        }

        if (et_player_name_two.text.isNullOrEmpty() && playerNum > 4){
            characterArray.add(Character("Samuel The Great"))
        }else if (playerNum > 4){
            characterArray.add(Character(et_player_name_two.text.toString()))
        }

        if (et_player_name_two.text.isNullOrEmpty() && playerNum > 5){
            characterArray.add(Character("Sean Of Connery"))
        }else if (playerNum > 5){
            characterArray.add(Character(et_player_name_two.text.toString()))
        }
    }
}