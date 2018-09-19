package com.tienhuynh.happystudio.smartparking.data.source

import com.tienhuynh.happystudio.smartparking.data.model.Location
import com.tienhuynh.happystudio.smartparking.data.source.datasource.LocationDataSource
import io.reactivex.Single

/**
 * Created by TienHuynh3 on 19/09/2018.
 * Copyright © Happy Tech Studio
 */
class LocationRepository : LocationDataSource {
    override fun getLocation(): Single<List<Location>> {
        //TODO dummy data
        return Single.just(listOf(Location(0, 0), Location(0, 0),
                Location(0, 0)))
    }
}
