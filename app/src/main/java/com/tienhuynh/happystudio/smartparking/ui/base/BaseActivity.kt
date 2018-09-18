package com.tienhuynh.happystudio.smartparking.ui.base

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.tienhuynh.happystudio.smartparking.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.ctx

/**
 * Created by TienHuynh3 on 30/05/2018.
 * Copyright © Happy Tech Studio
 */
abstract class BaseActivity : AppCompatActivity() {

    private val subscription: CompositeDisposable = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideActionBar()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStart() {
        super.onStart()
    }


    override fun onResume() {
        super.onResume()
        onBindViewModel()
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected fun addDisposables(vararg ds: Disposable) {
        ds.forEach { subscription.add(it) }
    }

    private fun hideActionBar() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(ctx, R.color.colorApp)
            }
            window.requestFeature(Window.FEATURE_ACTION_BAR)
            supportActionBar?.hide()
    }

    /**
     * This function is used to define subscription
     */
    abstract fun onBindViewModel()

    abstract fun getContainer(): Int

    abstract fun getCurrentFragment(): Fragment?
}