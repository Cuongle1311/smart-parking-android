package com.tienhuynh.happystudio.smartparking.ui.base

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.support.v4.indeterminateProgressDialog

/**
 * Created by TienHuynh3 on 30/05/2018.
 * Copyright © Happy Tech Studio
 */
abstract class BaseFragment : Fragment() {
    private val subscription: CompositeDisposable = CompositeDisposable()
    private val progressDialog by lazy {
        indeterminateProgressDialog("msg", "title")
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }

    override fun onResume() {
        super.onResume()
        onBindViewModel()
    }

    protected fun addDisposables(vararg ds: Disposable) {
        ds.forEach { subscription.add(it) }
    }

    protected fun showProgressDialog(message: String, title: String) {
        progressDialog.setMessage(message)
        progressDialog.setTitle(title)
    }

    protected fun showProgressDialog() {
        progressDialog.show()
    }

    protected fun hideProgressDialog() {
        progressDialog.hide()
    }

    /**
     * This function is used to define subscription
     */
    abstract fun onBindViewModel()
}
