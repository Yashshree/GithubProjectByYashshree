package com.app.githubprojectbyyashshree.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.githubprojectbyyashshree.models.GithubIssue


@Dao
interface IssueListDao {
    @Query("SELECT * FROM githubissue")
    fun getAll(): ArrayList<GithubIssue>

    @Insert
    fun insertAll(vararg todo: GithubIssue)
}