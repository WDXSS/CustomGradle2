package com.example.kotlin._5kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpractice.News
import com.example.kotlin.R
import kotlinx.android.synthetic.main.kotlin_05_news_content_activity.*
import kotlinx.android.synthetic.main.kotlin_05_news_title_frag.*
import java.util.*
import kotlin.collections.ArrayList

class NewsTitleFragment : Fragment() {
    private var isTwoPane = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.kotlin_05_news_title_frag, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //判断 activity 中是否 有 contentFragment
        val act: NewsMainActivity = activity as NewsMainActivity
        val frameLayout = act.findViewById<FrameLayout>(R.id.newsContentLayout)
        isTwoPane = frameLayout != null
        println("isTwoPane = $isTwoPane")
//        isTwoPane = act.isTwoPane

        val layoutManager = LinearLayoutManager(activity)
        newsTitleRecyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(getNews())
        newsTitleRecyclerView.adapter = adapter
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News("This is news title $i", getRandomLengthString("This is news content $i. "))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String): String {
        val n = Random().nextInt(20) + 1
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }


    inner class NewsAdapter(val newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_05_news_item, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPane) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
                    val fragment = newsContentFrag as NewsContentFragment
                    fragment.refresh(news.title, news.content) //刷新NewsContentFragment界面
                } else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    NewsContentActivity.startActivity(parent.context, news.title, news.content);
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount() = newsList.size

    }

}