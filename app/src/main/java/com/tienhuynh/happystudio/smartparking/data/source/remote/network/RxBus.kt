package com.tienhuynh.happystudio.smartparking.data.source.remote.network

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by TienHuynh3 on 19/05/2018.
 * Copyright © Happy Tech Studio
 */
object RxBus {
    private val publisher = PublishSubject.create<Any>()

    /**
     * Emit item to listen
     */
    fun publish(event: Any) {
        publisher.onNext(event)
    }

    /**
     * Listen should return an Observable and not the publisher
     * Using ofType we filter only events that match that class type
     */
    fun <T> listen(eventType: Class<T>): Observable<T> = publisher.ofType(eventType)
}
