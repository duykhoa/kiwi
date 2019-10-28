package io.github.fromsource.kiwi.core

import io.github.fromsource.kiwi.core.collection.ListShould
import io.github.fromsource.kiwi.core.number.IntShould
import io.github.fromsource.kiwi.core.string.StringShould

fun <T> List<T>.should() = ListShould(this)
fun Int.should() = IntShould(this)
fun String.should() = StringShould(this)