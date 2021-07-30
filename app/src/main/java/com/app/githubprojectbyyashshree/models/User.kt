package com.app.githubprojectbyyashshree.models

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

/*class User(
    @ColumnInfo(name = "login")
    @SerializedName("login") var name: String,
    @ColumnInfo(name = "avatar_url")
    @SerializedName("avatar_url") var imageUrl: String
)*/

class User(@SerializedName("login")  var name : String,
           @SerializedName("avatar_url")  var imageUrl : String)


