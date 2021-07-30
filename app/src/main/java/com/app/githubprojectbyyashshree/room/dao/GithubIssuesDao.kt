package com.app.githubprojectbyyashshree.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.githubprojectbyyashshree.models.GithubIssue

@Dao
interface GithubIssuesDao {

    //@Query("SELECT * FROM github_table")
    fun getAllGithubIssues(): ArrayList<GithubIssue>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(githubIssue: GithubIssue) : Long
}
