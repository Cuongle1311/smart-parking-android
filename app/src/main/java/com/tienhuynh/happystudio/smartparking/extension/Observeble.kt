package com.tienhuynh.happystudio.smartparking.extension

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Make Rx run to UI thread
 * Created by TienHuynh3 on 04/06/2018.
 * Copyright © Happy Tech Studio
 */

internal fun <T> Observable<T>.observeOnUiThread(): Observable<T> =
                this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

internal fun <T> Single<T>.observeOnUiThread(): Single<T> =
        this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())