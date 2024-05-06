package com.example.fragmentbestpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class NewsContentFragment : Fragment() {

    private lateinit var view: View

    companion object {
        lateinit var contentLayout: LinearLayout
        lateinit var newsTitle: TextView
        lateinit var newsContent: TextView
        lateinit var title: String
        lateinit var content: String
        var isTwoPane = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.news_content_frag, container, false)
        initView()
        return view
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (!isTwoPane)
            refresh(title, content)
    }
    private fun initView() {
        contentLayout = view.findViewById(R.id.contentLayout)
        newsTitle = view.findViewById(R.id.newsTitle)
        newsContent = view.findViewById(R.id.newsContent)
    }

    fun refresh(title: String, content: String) {
        contentLayout.visibility = View.VISIBLE
        newsTitle.text = title //刷新新聞標題
        newsContent.text = content //刷新新聞的內容
    }

    fun getNews(title: String, content: String) {
        NewsContentFragment.title = title
        NewsContentFragment.content = content
    }
}
