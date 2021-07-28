package com.app.githubprojectbyyashshree.utils

import android.app.Application
import com.app.githubprojectbyyashshree.repository.GithubIssuesRepository
import com.app.githubprojectbyyashshree.room.GithubDatabase

class GithubApplication : Application() {
    val database by lazy { GithubDatabase.getDatabase(this) }
    val repository by lazy { GithubIssuesRepository(database.issuesListDao()) }
}