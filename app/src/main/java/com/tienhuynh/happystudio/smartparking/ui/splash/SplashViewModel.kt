package com.tienhuynh.happystudio.smartparking.ui.splash

import com.tienhuynh.happystudio.smartparking.data.model.Location
import com.tienhuynh.happystudio.smartparking.data.source.LocationRepository
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by TienHuynh3 on 19/09/2018.
 * Copyright © Happy Tech Studio
 */
class SplashViewModel(private val locationRepository: LocationRepository) : SplashVMContract {

    private val locations = mutableListOf<Location>()
    private val updateProgressStatus = BehaviorSubject.create<Boolean>()

    override fun getLocationsFromSever(): Single<List<Location>> {

        return locationRepository.getLocation()
                .doOnSubscribe {
                    updateProgressStatus.onNext(true)
                }
                .doOnSuccess {
                    updateProgressStatus.onNext(false)
                    locations.clear()
                    locations.addAll(it)
                }
    }

    override fun getLocations() = locations

    override fun updateProgressStatus(): BehaviorSubject<Boolean> = updateProgressStatus
}
