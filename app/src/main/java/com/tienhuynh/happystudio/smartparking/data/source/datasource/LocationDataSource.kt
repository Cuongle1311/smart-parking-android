package com.tienhuynh.happystudio.smartparking.data.source.datasource

import com.tienhuynh.happystudio.smartparking.data.model.Location
import io.reactivex.Single

/**
 * Created by TienHuynh3 on 19/09/2018.
 * Copyright © Happy Tech Studio
 */
interface LocationDataSource {

    fun getLocation(): Single<List<Location>>
}