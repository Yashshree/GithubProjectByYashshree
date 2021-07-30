package com.app.githubprojectbyyashshree.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.githubprojectbyyashshree.R
import com.app.githubprojectbyyashshree.utils.Constants
import com.app.githubprojectbyyashshree.utils.GithubApplication
import com.app.githubprojectbyyashshree.viewmodel.GithubIssuesViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_github_issues.*

private lateinit var githubIssuesViewModel: GithubIssuesViewModel

class GithubIssuesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_issues)
        initView()
    }

    private fun initView() {
        githubIssuesViewModel =
            ViewModelProvider.NewInstanceFactory().create(GithubIssuesViewModel::class.java)

       /* githubIssuesViewModel=
            GithubIssuesViewModel((application as GithubApplication).repository)
*/

        githubIssuesViewModel.getGithubIssuesList(Constants.GET_GITHUB_ISSUES).observe(this,
            Observer {
                if (it != null) {
                    txtLoading.visibility = View.GONE
                    val linearLayoutManager = LinearLayoutManager(this)
                    recyclerViewGithubIssues.layoutManager = linearLayoutManager
                    recyclerViewGithubIssues.adapter = GithubIssueAdapter(it)
                    recyclerViewGithubIssues.addItemDecoration(
                        DividerItemDecoration(
                            this,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                }
            })
    }
}