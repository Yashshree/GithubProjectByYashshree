package com.app.githubprojectbyyashshree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.githubprojectbyyashshree.models.GithubIssue
import com.app.githubprojectbyyashshree.repository.GithubIssuesRepository
import org.json.JSONObject


class GithubIssuesViewModel(var githubIssuesRepository: GithubIssuesRepository) :  ViewModel(){

    fun getGithubIssuesList(url:String): LiveData<ArrayList<GithubIssue>> {
       /* return GithubIssuesRepository
            .instance
            .getGithubIssuesList(url)*/

        return githubIssuesRepository.getGithubIssuesList(url)

    }

    class GithubViewModelFactory(private val repository: GithubIssuesRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GithubIssuesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GithubIssuesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}