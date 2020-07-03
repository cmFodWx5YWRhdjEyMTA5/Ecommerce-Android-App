package com.vishal.store.activity

import android.os.Bundle
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.fragments.SearchFragment
import com.vishal.store.utils.extensions.addFragment

class SearchActivity : AppBaseActivity() {

    private val mSearchFragment = SearchFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search2)
        addFragment(mSearchFragment, R.id.fragmentContainer)
    }

}