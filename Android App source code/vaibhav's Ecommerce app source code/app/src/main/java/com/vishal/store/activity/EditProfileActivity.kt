package com.vishal.store.activity

import android.os.Bundle
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.fragments.ProfileFragment
import com.vishal.store.utils.extensions.addFragment
import kotlinx.android.synthetic.main.toolbar.*

class EditProfileActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        setToolbar(toolbar)
        title=getString(R.string.lbl_edit_profile)
        addFragment(ProfileFragment(),R.id.profilecontainer)
    }
}
