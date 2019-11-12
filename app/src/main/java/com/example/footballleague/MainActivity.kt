package com.example.footballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballleague.adapter.FootballRVAdapter
import com.example.footballleague.model.FootballTeamsModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {
    private var items: MutableList<FootballTeamsModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        verticalLayout {
            recyclerView {
                layoutManager = GridLayoutManager(context,2)
                addItemDecoration(DividerItemDecoration(context,1))
                adapter = FootballRVAdapter(items){
                    startActivity<DetailActivity>("ITEM" to it)
                }
            }.lparams(height= matchParent,width = wrapContent)
        }
    }

    private fun initData(){
        val gambarLeague = resources.obtainTypedArray(R.array.gambar_league)
        val namaLeague = resources.getStringArray(R.array.nama_league)
        val deskripsiLeague = resources.getStringArray(R.array.deskripsi_league)
        items.clear()
        for (i in namaLeague.indices) {
            items.add(FootballTeamsModel(namaLeague[i],
                deskripsiLeague[i],
                gambarLeague.getResourceId(i,0)))
        }
//        Type array perlu di recylce
        gambarLeague.recycle()
    }
}
