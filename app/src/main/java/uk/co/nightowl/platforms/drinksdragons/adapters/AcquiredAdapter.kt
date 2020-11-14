package uk.co.nightowl.platforms.drinksdragons.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_acquired.view.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.models.Treasure

class AcquiredAdapter(private val context: Context, private var list: ArrayList<Treasure>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_acquired,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if(holder is MyViewHolder) {
            holder.itemView.tv_treasure_acquired.text = model.name
        }
    }

    private class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}