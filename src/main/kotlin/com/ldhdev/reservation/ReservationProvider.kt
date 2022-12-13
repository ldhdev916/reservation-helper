package com.ldhdev.reservation

import java.time.LocalTime
import kotlin.time.Duration

interface ReservationProvider {

    val at: LocalTime

    val randomized: Boolean

    val randomDelay: Duration

    suspend fun isReservationProcessed(): Boolean

    suspend fun recordReservationProcessed()

    suspend fun action()

    fun logDelay(delay: Duration) = Unit
}