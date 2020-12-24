package uk.co.nightowl.platforms.drinksdragons.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.dialog_equipment.view.*
import kotlinx.android.synthetic.main.dialog_special_outcome.view.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.models.Treasure

abstract class OutcomeDialog(
    context: Context,
    private val outcome: String
) : Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = LayoutInflater.from(context).inflate(
            R.layout.dialog_special_outcome, null)

        setContentView(view)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        setUpDialog(view)
    }

    private fun setUpDialog(view: View){
        view.tv_dialog_outcome.text = outcome
    }
}