package com.app.githubprojectbyyashshree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.githubprojectbyyashshree.models.GithubIssue
import com.app.githubprojectbyyashshree.repository.GithubIssuesRepository
import org.json.JSONObject


class GithubIssuesViewModel() :  ViewModel(){

    fun getGithubIssuesList(url:String): LiveData<ArrayList<GithubIssue>> {
        return GithubIssuesRepository.instance.getGithubIssuesList(url)
    }
}