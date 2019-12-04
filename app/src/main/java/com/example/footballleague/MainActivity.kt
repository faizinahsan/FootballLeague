package com.example.footballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.footballleague.adapter.FootballRVAdapter
import com.example.footballleague.api.ApiMainService
import com.example.footballleague.model.leagues.Leagues
import com.example.footballleague.model.leagues.LeaguesResponses
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private var items: ArrayList<Leagues> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            recyclerView {
                layoutManager = GridLayoutManager(context,2)
                addItemDecoration(DividerItemDecoration(context,1))
                ApiMainService().service.getLeagues().enqueue(object : retrofit2.Callback<LeaguesResponses>{
                    override fun onFailure(call: Call<LeaguesResponses>, t: Throwable) {
                        Log.d("GAGAL","GAGAL Mengambil Leagues")
                    }

                    override fun onResponse(
                        call: Call<LeaguesResponses>,
                        response: Response<LeaguesResponses>
                    ) {
                        if (response.code() == 200){
                            response.body()?.leagues?.let { items.addAll(it) }
                            adapter = FootballRVAdapter(items){
                                startActivity<DetailActivity>("ITEM" to it)
                            }
                        }
                        Log.d("BERHASIL","BERHASIL")

                    }


                })
            }.lparams(height= matchParent,width = wrapContent)
        }
    }

}
