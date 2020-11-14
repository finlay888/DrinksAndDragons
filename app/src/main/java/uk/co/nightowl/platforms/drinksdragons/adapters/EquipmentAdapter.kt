package uk.co.nightowl.platforms.drinksdragons.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_equipment.view.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.dialogs.EquipmentDialog
import uk.co.nightowl.platforms.drinksdragons.models.Treasure


class EquipmentAdapter(
    private val context: Context, private var list: ArrayList<Treasure>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickListener : OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_equipment,
                parent,
                false
            )
        )
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if(holder is MyViewHolder) {

            holder.itemView.iv_item_equipment.setImageResource(model.image)
            when(model.rating){
                1 -> {
                    holder.itemView.tv_equipment_rating.text = context.getString(R.string.common)
                    holder.itemView.tv_equipment_rating.setTextColor(context.getColor(R.color.colorGray))
                }
                2 -> {
                    holder.itemView.tv_equipment_rating.text = context.getString(R.string.rare)
                    holder.itemView.tv_equipment_rating.setTextColor(context.getColor(R.color.colorRare))
                }
                3 -> {
                    holder.itemView.tv_equipment_rating.text = context.getString(R.string.epic)
                    holder.itemView.tv_equipment_rating.setTextColor(context.getColor(R.color.colorEpic))
                }
            }
            holder.itemView.setOnClickListener {
                if(onClickListener != null){
                    onClickListener!!.onClick(position, model)
                }
            }
            holder.itemView.btn_inspect.setOnClickListener {
                val treasureDialog = object : EquipmentDialog(
                    context, model
                ){
                }
                treasureDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                treasureDialog.show()
            }
            setFadeAnimation(holder.itemView)
        }
    }

    interface OnClickListener {
        fun onClick(position: Int, model: Treasure)
    }

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 250
        view.startAnimation(anim)
        val anim2 = ScaleAnimation(
            0.0f,
            1.0f,
            0.0f,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        anim2.duration = 250
        view.startAnimation(anim2)
    }
}