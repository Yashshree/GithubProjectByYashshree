package com.app.githubprojectbyyashshree.models

import com.google.gson.annotations.SerializedName

class GithubIssue(
    @SerializedName("title") var title: String,
    @SerializedName("body") var issueDetail: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("user") var user: User,
    @SerializedName("comments_url") var commentUrl : String
)

