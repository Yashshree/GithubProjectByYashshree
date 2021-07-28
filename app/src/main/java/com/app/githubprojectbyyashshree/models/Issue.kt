package com.app.githubprojectbyyashshree.models

import com.google.gson.annotations.SerializedName

class Issue(
    @SerializedName("title") var title: String,
    @SerializedName("body") var issueDetail: String,
    @SerializedName("updated_at") var updatedAt: String
)