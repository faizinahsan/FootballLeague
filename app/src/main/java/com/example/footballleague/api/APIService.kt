package com.example.footballleague.api

import com.example.footballleague.model.leagues.Leagues
import com.example.footballleague.model.leagues.LeaguesResponses
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("api/v1/json/1/all_leagues.php")
    fun getLeagues() : Call<LeaguesResponses>
    fun getLeague(@Query("idLeague") idLeague:String) : Call<Leagues>
}