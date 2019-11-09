package io.fromsource.kiwi.core.collection

import io.fromsource.kiwi.core.BeEqual
import io.fromsource.kiwi.core.assert

open class CollectionShould<T, R : CollectionShould<T, R>>(open val actual: Collection<T>) :
    BeEqual<Collection<T>, CollectionShould<T, R>> {
    override fun actual(): Collection<T> = actual

    open fun beEmpty(): R {
        val message = "$actual should be empty"
        assert(actual.isEmpty()) { message }
        return this as R
    }

    open infix fun haveSize(size: Int): R {
        val hasSize = actual.size == size
        val message = "Expected size: $size, actual: ${actual.size}"
        assert(hasSize) { message }
        return this as R
    }

    open infix fun contain(element: T): R {
        val contains = actual.contains(element)
        val message = "$actual should contain $element"
        assert(contains) { message }
        return this as R
    }

    open fun contain(vararg elements: T): R {
        elements.forEach {
            val message = "$actual should contain $it"
            assert(actual.contains(it)) { message }
        }
        return this as R
    }

    open infix fun matchAny(predicate: (T) -> Boolean): R {
        val matchAny = actual.any(predicate)
        val message = "$actual should match any predicate"
        assert(matchAny) { message }
        return this as R
    }

    open infix fun matchAll(predicate: (T) -> Boolean): R {
        val matchAll = actual.any(predicate)
        val message = "$actual should match all predicate"
        assert(matchAll) { message }
        return this as R
    }

    open infix fun <S : Comparable<S>> beSorted(selector: (T) -> S?): R {
        val sorted = actual().sortedBy(selector)
        val message = "$actual should be sorted: $sorted"
        assert(actual.toList() == sorted) { message }
        return this as R
    }
}

fun <T : Comparable<T>, R : CollectionShould<T, R>> CollectionShould<T, R>.beSorted(): R {
    val sorted = actual().sorted()
    val message = "$actual should be sorted: $sorted"
    assert(actual.toList() == sorted) { message }
    return this as R
}