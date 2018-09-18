package com.tienhuynh.happystudio.smartparking.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.tienhuynh.happystudio.smartparking.R
import com.tienhuynh.happystudio.smartparking.extension.setFontApp
import com.tienhuynh.happystudio.smartparking.ui.base.BaseFragment
import kotlinx.android.synthetic.main.splash_fragment.view.*
import org.jetbrains.anko.support.v4.ctx


/**
 * Created by TienHuynh3 on 18/09/2018.
 * Copyright © Happy Tech Studio
 */
class SplashFragment : BaseFragment() {

    companion object {
        fun newInstance(): SplashFragment = SplashFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.splash_fragment, container, false)
        handleAnimationSplash(view)
        return view
    }

    override fun onBindViewModel() {
        // no-op
    }

    override fun setFontApp(view: View) {
        view.tvTitle.setFontApp()
    }

    private fun handleAnimationSplash(view: View) {
        view.imgSplashLogo.startAnimation(AnimationUtils.loadAnimation(ctx,
                R.anim.slide_in_left))

        view.tvTitle.startAnimation(AnimationUtils.loadAnimation(ctx,
                R.anim.slide_in_right))
    }

}
