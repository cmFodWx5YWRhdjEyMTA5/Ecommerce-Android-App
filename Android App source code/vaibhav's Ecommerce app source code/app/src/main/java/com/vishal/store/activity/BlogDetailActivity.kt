package com.vishal.store.activity

import android.os.Bundle
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.models.Blog
import com.vishal.store.utils.Constants.KeyIntent.DATA
import com.vishal.store.utils.extensions.loadImageFromUrl
import kotlinx.android.synthetic.main.activity_blog_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class BlogDetailActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_detail)

        setToolbar(toolbar)

        val blog = intent.getSerializableExtra(DATA) as Blog
        title = blog.title

        ivProduct.loadImageFromUrl(blog.image!!)
        tvTitle.text = blog.title
        tvPublishDate.text = blog.publish_date
        tvDescription.text = blog.description
    }
}
