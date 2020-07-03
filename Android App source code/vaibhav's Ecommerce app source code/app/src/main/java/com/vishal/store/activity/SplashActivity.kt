package com.vishal.store.activity

import android.content.pm.PackageManager.GET_SIGNATURES
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Build
import android.os.Bundle
import android.util.Log
import com.vishal.store.AppBaseActivity
import com.vishal.store.R
import com.vishal.store.utils.Constants
import com.vishal.store.utils.extensions.getSharedPrefInstance
import com.vishal.store.utils.extensions.launchActivity
import com.vishal.store.utils.extensions.runDelayed
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class SplashActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            val info = packageManager.getPackageInfo(packageName, GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Log.d("KeyHash:", Base64.getEncoder().encodeToString(md.digest()))
                }
            }
        } catch (e: NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) { }
        runDelayed(1000) {
            if (getSharedPrefInstance().getBooleanValue(Constants.SharedPref.SHOW_SWIPE)) {
                launchActivity<DashBoardActivity>()
            } else {
                launchActivity<WalkThroughActivity>()
            }
            finish()
        }
    }
}