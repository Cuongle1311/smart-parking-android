package com.tienhuynh.happystudio.smartparking.extension

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by TienHuynh3 on 28/05/2018.
 * Copyright © Happy Tech Studio
 */

/**
 * Toast
 */
internal fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

/**
 * Replace Fragment
 */
internal fun FragmentActivity.replaceFragment(@IdRes containerId: Int, fragment: Fragment, isAddBackStack: Boolean) {
    if (supportFragmentManager.findFragmentByTag(fragment.javaClass.simpleName) == null) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment, fragment.javaClass.simpleName)
        if (isAddBackStack) {
            transaction.addToBackStack(fragment.javaClass.simpleName)
        }
        transaction.commit()
    }
}

/**
 * inflate view layout for view group
 */
internal fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

/**
 * get current fragment
 */
internal fun FragmentActivity.getCurrentFragment(@IdRes containerId: Int) = supportFragmentManager.findFragmentById(containerId)

/**
 * Pop Fragment
 */
internal fun FragmentActivity.popFragment() {
    supportFragmentManager.popBackStackImmediate()
}

//TODO Add more extension such as : add fragment , hide show keyboard .....etc....