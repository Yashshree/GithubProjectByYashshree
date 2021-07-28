package com.app.githubprojectbyyashshree.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
class User(@SerializedName("login")  @ColumnInfo(name = "name")  var name : String,
           @SerializedName("avatar_url") @ColumnInfo(name = "avatarUrl") var imageUrl : String)