package com.example.footballleague.adapter

import android.text.Layout
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballleague.model.FootballTeamsModel
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class FootballRVAdapter(val items:List<FootballTeamsModel>,private val listener:(FootballTeamsModel)->Unit):
    RecyclerView.Adapter<FootballRVAdapter.ViewHolder>() {
    companion object{
        val idGambar = 1
        val idNama = 2
        val idDeskripsi = 3
    }
    class FootballRVAdapterUI: AnkoComponent<ViewGroup>{
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                verticalLayout{
                    lparams(width= matchParent,height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    imageView{
                        id = idGambar
                    }.lparams(height = dip(75),width = dip(75))
                    textView {
                        id = idNama
                        textSize = 20f
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams{
                        margin=dip(16)
                    }
                }
            }
        }

    }
    class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val namaLeague = itemView.findViewById<TextView>(idNama)
        val gambarLeague = itemView.findViewById<ImageView>(idGambar)
        fun bindItem(items:FootballTeamsModel,listener: (FootballTeamsModel) -> Unit){
            namaLeague.text = items.namaLeague
            items.gambarLeague?.let { Picasso.get().load(it).fit().into(gambarLeague) }
            itemView.setOnClickListener { listener(items) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FootballRVAdapter.ViewHolder {
        return ViewHolder(
            FootballRVAdapterUI().createView(AnkoContext.Companion.create(parent.context,parent))
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FootballRVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

}