package com.vishal.store.activity

import android.os.Bundle
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.fragments.MyCartFragment
import com.vishal.store.utils.Constants.AppBroadcasts.CART_COUNT_CHANGE
import com.vishal.store.utils.extensions.BroadcastReceiverExt
import com.vishal.store.utils.extensions.addFragment
import com.vishal.store.utils.extensions.getCartListFromPref
import com.vishal.store.utils.extensions.launchActivityWithNewTask
import kotlinx.android.synthetic.main.toolbar.*

class MyCartActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)
        setToolbar(toolbar)
        title = getString(R.string.menu_my_cart)

        val fr = MyCartFragment()
        addFragment(fr, R.id.container)
        BroadcastReceiverExt(this) {
            onAction(CART_COUNT_CHANGE) {
                if (fr.isAdded) {
                    fr.invalidateCartLayout(getCartListFromPref())
                }
            }
        }
    }

    fun shopNow() {
        launchActivityWithNewTask<DashBoardActivity>()
        finish()
    }

}
