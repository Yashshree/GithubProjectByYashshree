package com.app.githubprojectbyyashshree.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.githubprojectbyyashshree.R
import com.app.githubprojectbyyashshree.models.GithubIssue
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.item_github_issues_layout.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class GithubIssueAdapter(private var issuesList: ArrayList<GithubIssue>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<GithubIssueAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_github_issues_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val issue = issuesList[position]

        if (!issue.title.isNullOrEmpty())
            holder.itemView.txtTitle.text = issue.title
        else
            holder.itemView.txtTitle.visibility = View.GONE
        holder.itemView.txtDescription.text = issue.issueDetail

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a")
        val parsedDate: Date = inputFormat.parse(issue.updatedAt)

        holder.itemView.txtUpdatedAt.text = outputFormat.format(parsedDate)

        holder.itemView.setOnClickListener {

            val intent = Intent(context, GithubIssuesDetailsActivity::class.java)
            intent.putExtra("comment_url", issue.commentUrl)
            context.startActivity(intent)
        }

        Glide.with(context)
            .load(issue.user.imageUrl).into(holder.itemView.imgUser)

        holder.itemView.txtUserName.text = issue.user.name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int = issuesList.size

}
