package com.app.githubprojectbyyashshree.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*class GithubIssue(
    @SerializedName("title") var title: String,
    @SerializedName("body") var issueDetail: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("user") var user: User,
    @SerializedName("comments_url") var commentUrl : String
)*/

@Entity
class GithubIssue
    (
    @SerializedName("id")
    @PrimaryKey
    var id: Long,
    @SerializedName("title")
    @ColumnInfo(name = "title") var title: String,
    @SerializedName("body")
    @ColumnInfo(name = "body") var body: String,
    @SerializedName("updated_at")
    @ColumnInfo(name = "updatedAt") var updatedAt: String,
    @SerializedName("user")
    @ColumnInfo(name = "user") var user: User,
    @SerializedName("comments_url")
    @ColumnInfo(name = "commentsUrl") var commentUrl : String
)
