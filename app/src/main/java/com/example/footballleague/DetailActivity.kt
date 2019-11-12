package com.example.footballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.example.footballleague.model.FootballTeamsModel
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.nestedScrollView

class DetailActivity : AppCompatActivity() {
    companion object{
        val idGambarLeague = 1
        val idNamaLeague = 2
        val idDeskripsiLeague = 3
    }
    lateinit var namaLeagueTV : TextView
    lateinit var deskripsiLeagueTV : TextView
    lateinit var gambarLeagueTV : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nestedScrollView {
            verticalLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                gambarLeagueTV = imageView {
                    id = com.example.footballleague.DetailActivity.Companion.idGambarLeague
                }.lparams {
                    width = 300
                    height = 400
                }
                namaLeagueTV=textView {
                    id = com.example.footballleague.DetailActivity.Companion.idNamaLeague
                    textSize = 45f
                }.lparams{
                    margin = dip(16)
                }
                deskripsiLeagueTV=textView {
                    id = com.example.footballleague.DetailActivity.Companion.idDeskripsiLeague
                }.lparams{
                    margin = dip(16)
                }
            }
        }
        val item = intent.getParcelableExtra<FootballTeamsModel>("ITEM")
        namaLeagueTV.text = item.namaLeague.toString()
        deskripsiLeagueTV.text = item.deskripsiLeague.toString()
        item.gambarLeague?.let { Picasso.get().load(it).into(gambarLeagueTV) }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
