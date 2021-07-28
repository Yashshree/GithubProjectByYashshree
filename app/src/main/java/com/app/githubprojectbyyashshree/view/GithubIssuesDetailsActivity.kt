package com.app.githubprojectbyyashshree.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.githubprojectbyyashshree.R
import com.app.githubprojectbyyashshree.utils.Constants
import com.app.githubprojectbyyashshree.viewmodel.GithubIssuesViewModel
import kotlinx.android.synthetic.main.activity_github_issues_details.*

class GithubIssuesDetailsActivity : AppCompatActivity() {
    private lateinit var githubIssuesViewModel: GithubIssuesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_issues_details)
        initView()
    }

    private fun initView() {

        githubIssuesViewModel =
            ViewModelProvider.NewInstanceFactory().create(GithubIssuesViewModel::class.java)

        githubIssuesViewModel.getGithubIssuesList(intent.getStringExtra("comment_url").toString()).observe(this,
            Observer {
                if (it.size!=0) {
                    //  finish()
                    txtLoading.visibility = View.GONE
                    val  linearLayoutManager = LinearLayoutManager(this)
                    recyclerViewComments.layoutManager = linearLayoutManager

                    recyclerViewComments.adapter = GithubIssueAdapter(it)

                    recyclerViewComments.addItemDecoration(
                        DividerItemDecoration(this,
                        DividerItemDecoration.VERTICAL)
                    )
                }
                else {
                    finish()
                    Toast.makeText(
                        this,
                        getString(R.string.txt_no_comments_on_this_post),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}