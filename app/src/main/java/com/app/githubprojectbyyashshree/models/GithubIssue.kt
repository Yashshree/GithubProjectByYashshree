package com.app.githubprojectbyyashshree.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*@Entity(tableName = "github_table")
class GithubIssue(
    @PrimaryKey @ColumnInfo(name = "id")
    @SerializedName("id") var id: Long,
    @ColumnInfo(name = "title")
    @SerializedName("title") var title: String,
    @ColumnInfo(name = "body")
    @SerializedName("body") var issueDetail: String,
    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at") var updatedAt: String,
    @ColumnInfo(name = "user")
    @SerializedName("user") var user: User,
    @ColumnInfo(name = "comments_url")
    @SerializedName("comments_url") var commentUrl : String
)*/

class GithubIssue(

    @SerializedName("id") var id: Long,
    @SerializedName("title") var title: String,
    @SerializedName("body") var issueDetail: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("user") var user: User,
    @SerializedName("comments_url") var commentUrl : String
)

