package com.tienhuynh.happystudio.smartparking.ui.splash

import com.tienhuynh.happystudio.smartparking.data.model.Location
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by TienHuynh3 on 19/09/2018.
 * Copyright © Happy Tech Studio
 */
interface SplashVMContract {

    fun getLocationsFromSever(): Single<List<Location>>

    fun getLocations(): List<Location>

    fun updateProgressStatus(): BehaviorSubject<Boolean>
}