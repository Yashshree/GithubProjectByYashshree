package com.app.githubprojectbyyashshree.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.githubprojectbyyashshree.models.GithubIssue
import com.app.githubprojectbyyashshree.room.dao.IssueListDao

@Database(entities = arrayOf(GithubIssue::class), version = 1)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun issuesListDao(): IssueListDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: GithubDatabase? = null

        fun getDatabase(context: Context): GithubDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GithubDatabase::class.java,
                    "github_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}