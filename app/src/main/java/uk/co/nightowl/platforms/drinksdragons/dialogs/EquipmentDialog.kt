package uk.co.nightowl.platforms.drinksdragons.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.dialog_equipment.view.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.models.Treasure

abstract class EquipmentDialog(
    context: Context,
    private val treasure: Treasure
) : Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = LayoutInflater.from(context).inflate(
            R.layout.dialog_equipment, null)

        setContentView(view)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        setUpDialog(view)
    }

    private fun setUpDialog(view: View){
        view.tv_dialog_equipment_name.text = treasure.name
        view.iv_dialog_equipment.setImageResource(treasure.image)
        when(treasure.rating){
            1 -> {
                view.tv_dialog_rating.text = context.getString(R.string.common)
                view.tv_dialog_rating.setTextColor(context.getColor(R.color.colorGray))
            }
            2 -> {
                view.tv_dialog_rating.text = context.getString(R.string.rare)
                view.tv_dialog_rating.setTextColor(context.getColor(R.color.colorRare))
            }
            3 -> {
                view.tv_dialog_rating.text = context.getString(R.string.epic)
                view.tv_dialog_rating.setTextColor(context.getColor(R.color.colorEpic))
            }
        }
        view.tv_dialog_description.text = treasure.description
        view.tv_dialog_fight_stat.text = treasure.fight.toString()
        view.tv_dialog_charm_stat.text = treasure.charm.toString()
    }
}