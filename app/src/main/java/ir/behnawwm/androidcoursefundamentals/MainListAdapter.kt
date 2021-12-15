package ir.behnawwm.androidcoursefundamentals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainListAdapter(
    val list: List<MainListItem>
) :
    RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_list, parent, false)
        return MainListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        val currentItem = list[position]
        holder.apply {
            tvTitle.text = currentItem.title
            tvPrice.text = currentItem.price
            ivItem.background = holder.itemView.context.resources.getDrawable(currentItem.photo)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    /////////////////////////

    class MainListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val tvPrice = itemView.findViewById<TextView>(R.id.tv_price)
        val ivItem = itemView.findViewById<ImageView>(R.id.iv_item)

    }
}