package com.rolo.gltestrolando.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.rolo.gltestrolando.R
import com.rolo.gltestrolando.data.model.ItemGL
import com.rolo.gltestrolando.databinding.ItemGlBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gl.view.*

class MainAdapter(
    private val itemsGL: ArrayList<ItemGL>,
    private val itemClickListener: (ItemGL) -> Unit
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(var view: ItemGlBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(item: ItemGL, itemClickListener: (ItemGL) -> Unit) {
            itemView.title.text = item.title
            itemView.description.text = item.description

            Picasso
                .get()
                .load(item.image)
                .into(itemView.imageView)

            itemView.setOnClickListener {
                itemClickListener(item)
                val navController = Navigation.findNavController(
                    (view.root.context) as Activity,
                    R.id.nav_host_fragment
                )
                navController.navigate(R.id.action_listFragment_to_detailFragment,
                    null,
                    navOptions {
                        anim {
                            enter = android.R.animator.fade_in
                            exit = android.R.animator.fade_out
                        }
                    })
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemGlBinding>(inflater, R.layout.item_gl, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(itemsGL[position], itemClickListener)

    override fun getItemCount(): Int = itemsGL.size

    fun addData(list: List<ItemGL>) {
        itemsGL.addAll(list)
    }


}
