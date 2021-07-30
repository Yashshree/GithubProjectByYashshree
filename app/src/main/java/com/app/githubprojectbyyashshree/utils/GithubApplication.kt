package com.app.githubprojectbyyashshree.utils

import android.app.Application
import com.app.githubprojectbyyashshree.repository.GithubIssuesRepository
import com.app.githubprojectbyyashshree.room.GithubIssuesDatabase


class GithubApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { GithubIssuesDatabase.getDatabase(this) }
  //  val repository by lazy { GithubIssuesRepository(database.githubIssueDao()) }
}