package com.example.footballleague.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FootballTeamsModel
    (val namaLeague:String?, val deskripsiLeague:String?, val gambarLeague:Int?):Parcelable