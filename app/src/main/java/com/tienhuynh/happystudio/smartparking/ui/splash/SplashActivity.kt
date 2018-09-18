package com.tienhuynh.happystudio.smartparking.ui.splash

import android.os.Bundle
import android.support.v4.app.Fragment
import com.tienhuynh.happystudio.smartparking.R
import com.tienhuynh.happystudio.smartparking.extension.getCurrentFragment
import com.tienhuynh.happystudio.smartparking.extension.replaceFragment
import com.tienhuynh.happystudio.smartparking.ui.base.BaseActivity

/**
 * Created by TienHuynh3 on 18/09/2018.
 * Copyright © Happy Tech Studio
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        openSplashFragment()
    }

    override fun getContainer(): Int = R.id.splashContainer

    override fun getCurrentFragment(): Fragment? = getCurrentFragment(getContainer())

    override fun onBindViewModel() {

    }

    private fun openSplashFragment() {
        replaceFragment(R.id.splashContainer, SplashFragment.newInstance(), false)
    }
}