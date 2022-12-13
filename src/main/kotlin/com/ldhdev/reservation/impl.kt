package com.ldhdev.reservation

import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.seconds

suspend fun ReservationProvider.process() {
    val now = LocalTime.now()

    if (randomized) {
        val start = at.minusSeconds(randomDelay.inWholeSeconds)
        val end = at.plusSeconds(randomDelay.inWholeSeconds)

        if (now.isAfter(start) && now.isBefore(end) && !isReservationProcessed()) {
            recordReservationProcessed()

            val maxSeconds = now.until(end, ChronoUnit.SECONDS).toInt()
            val randomSeconds = Random.nextInt(0..maxSeconds)

            val delay = randomSeconds.seconds

            logDelay(delay)

            delay(delay)
            action()
        }

    } else {
        if (now.isAfter(at) && now.isBefore(at.plusMinutes(3)) && !isReservationProcessed()) {
            recordReservationProcessed()
            action()
        }
    }
}