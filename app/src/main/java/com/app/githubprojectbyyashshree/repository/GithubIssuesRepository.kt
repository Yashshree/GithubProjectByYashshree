package com.app.githubprojectbyyashshree.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.githubprojectbyyashshree.models.GithubIssue
import com.app.githubprojectbyyashshree.models.User
import com.app.githubprojectbyyashshree.utils.Constants
import com.enyotalearning.learninghub.utils.WebServicesHelper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class GithubIssuesRepository() {

    companion object {
        private var githubIssuesRepository: GithubIssuesRepository? = null

        val instance: GithubIssuesRepository
            @Synchronized get() {
                if (githubIssuesRepository == null) {
                    githubIssuesRepository = GithubIssuesRepository()
                }
                return githubIssuesRepository!!
            }
    }

        fun getGithubIssuesList(url:String): LiveData<ArrayList<GithubIssue>> {
        val data = MutableLiveData<ArrayList<GithubIssue>>()
        WebServicesHelper.getRequest(url = url,
            listener = object : WebServicesHelper.ResponseListener {
                override fun onSuccess(response: String) {
                   // data.value = Gson().fromJson(response, GithubIssue::class.java)
                   // data.value =   Gson().fromJson(response, Array<GithubIssue>::class.java)


                    val issuesListType: Type = object : TypeToken<ArrayList<GithubIssue?>?>() {}.type

                    val issuesList: ArrayList<GithubIssue> = Gson().fromJson(response, issuesListType)


                    data.value = issuesList
                }

                override fun onError(errorMessage: String) {
                    Log.e("error","error")


                }

            })
        return data
    }
}