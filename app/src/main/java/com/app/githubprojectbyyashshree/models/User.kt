package com.app.githubprojectbyyashshree.models

import com.google.gson.annotations.SerializedName

class User(@SerializedName("login")  var name : String,
           @SerializedName("avatar_url")  var imageUrl : String)