package com.tienhuynh.happystudio.smartparking.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.tienhuynh.happystudio.smartparking.R
import com.tienhuynh.happystudio.smartparking.extension.getCurrentFragment
import com.tienhuynh.happystudio.smartparking.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBindViewModel() {
        //No-op
    }

    override fun getContainer(): Int = 0

    override fun getCurrentFragment(): Fragment? = getCurrentFragment(getContainer())
}
