package com.vishal.store.activity

import android.os.Bundle
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.fragments.ViewAllProductFragment
import com.vishal.store.utils.Constants
import com.vishal.store.utils.Constants.AppBroadcasts.CART_COUNT_CHANGE
import com.vishal.store.utils.extensions.BroadcastReceiverExt
import com.vishal.store.utils.extensions.replaceFragment
import kotlinx.android.synthetic.main.toolbar.*

class ViewAllProductActivity : AppBaseActivity() {

    private var mFragment: ViewAllProductFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        setToolbar(toolbar)

        title = intent.getStringExtra(Constants.KeyIntent.TITLE)
        val mViewAllId = intent.getIntExtra(Constants.KeyIntent.VIEWALLID, 0)
        val mCategoryId = intent.getIntExtra(Constants.KeyIntent.KEYID, -1)

        mFragment = ViewAllProductFragment.getNewInstance(mViewAllId, mCategoryId)
        replaceFragment(mFragment!!, R.id.fragmentContainer)
        BroadcastReceiverExt(this) { onAction(CART_COUNT_CHANGE) { mFragment?.setCartCount() } }
        showBannerAds()
    }
}