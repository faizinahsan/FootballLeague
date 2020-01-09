package com.example.footballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.footballleague.api.ApiMainService
import com.example.footballleague.model.events.EventsResponses
import com.example.footballleague.model.teams.TeamResponses
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import retrofit2.Call
import retrofit2.Response

class DetailMatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        val getId = intent?.getIntExtra("id_match",0)
        if (getId != null) {
            ApiMainService().service.getMatchbyId(getId).enqueue(object :retrofit2.Callback<EventsResponses>{
                override fun onFailure(call: Call<EventsResponses>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<EventsResponses>,
                    response: Response<EventsResponses>
                ) {
                    id_event_name_detail.text = response.body()?.events?.get(0)?.strEvent
                    id_home_team_detail.text = response.body()?.events?.get(0)?.strHomeTeam
                    id_away_team_detail.text = response.body()?.events?.get(0)?.strAwayTeam
                    id_home_score_detail.text = response.body()?.events?.get(0)?.intHomeScore
                    id_away_score_detail.text = response.body()?.events?.get(0)?.intAwayScore
                    id_round_detail.text = response.body()?.events?.get(0)?.intRound.toString()
                    Log.d("Id Home Team", response.body()?.events?.get(0)?.idHomeTeam.toString())
                    Log.d("Id Away Team", response.body()?.events?.get(0)?.idAwayTeam.toString())
                    response.body()?.events?.get(0)?.idHomeTeam?.let { getHomeLogoTeam(it) }
                    response.body()?.events?.get(0)?.idAwayTeam?.let { getAwayLogoTeam(it) }
                    id_date_event_detail.text = response.body()?.events?.get(0)?.strDate
                    id_time_event_detail.text = response.body()?.events?.get(0)?.strTime
                }

            })
        }
    }
    private fun getHomeLogoTeam(idTeam:Int){
        ApiMainService().service.getTeamById(idTeam).enqueue(object :retrofit2.Callback<TeamResponses>{
            override fun onFailure(call: Call<TeamResponses>, t: Throwable) {

            }

            override fun onResponse(call: Call<TeamResponses>, response: Response<TeamResponses>) {
                Picasso.get().load(response.body()?.teams?.get(0)?.strTeamBadge).into(id_logo_home_detail)
            }
        })
    }
    private fun getAwayLogoTeam(idTeam:Int){
        ApiMainService().service.getTeamById(idTeam).enqueue(object :retrofit2.Callback<TeamResponses>{
            override fun onFailure(call: Call<TeamResponses>, t: Throwable) {

            }

            override fun onResponse(call: Call<TeamResponses>, response: Response<TeamResponses>) {
                Picasso.get().load(response.body()?.teams?.get(0)?.strTeamBadge).into(id_logo_away_detail)
            }
        })
    }
}
