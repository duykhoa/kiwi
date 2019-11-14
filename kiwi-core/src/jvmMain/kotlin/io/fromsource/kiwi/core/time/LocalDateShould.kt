package io.fromsource.kiwi.core.time

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

class LocalDateShould(private val actual: LocalDate) : DateShould<LocalDate> {
    override fun actual() = actual

    override fun beAfter(expected: LocalDate) = beGreaterThan(expected)

    override fun beBefore(expected: LocalDate) = beLessThan(expected)

    override fun haveSameYearAs(expected: LocalDate): DateShould<LocalDate> {
        val message = "${actual()} should have the same year as $expected"
        assert(actual().year == expected.year) { message }
        return this
    }

    override fun haveSameMonthAs(expected: LocalDate): DateShould<LocalDate> {
        val message = "${actual()} should have the same month as $expected"
        assert(actual().month == expected.month) { message }
        return this
    }

    override fun haveSameDayOfYearAs(expected: LocalDate): DateShould<LocalDate> {
        val message = "${actual()} should have the same day of year as $expected"
        assert(actual().month == expected.month &&
                actual().dayOfMonth == expected.dayOfMonth) { message }
        return this
    }

    override fun haveSameDayOfWeekAs(expected: LocalDate): DateShould<LocalDate> {
        val message = "${actual()} should have the same day of week as $expected"
        assert(actual().dayOfWeek == expected.dayOfWeek) { message }
        return this
    }

    override fun haveSameEpochDayAs(expected: Long): DateShould<LocalDate> {
        val message = "${actual()} should have $expected epoch days"
        assert(actual().toEpochDay() == expected) { message }
        return this
    }

    override fun beAtYear(expected: Int): DateShould<LocalDate> {
        val message = "${actual()} should be at $expected year"
        assert(actual().year == expected) { message }
        return this
    }

    override fun beAtMonth(expected: Month): DateShould<LocalDate> {
        val message = "${actual()} should be at $expected month"
        assert(actual().month== expected) { message }
        return this
    }

    override fun beDayOfTheYear(expected: Int): DateShould<LocalDate> {
        val message = "${actual()} should be $expected day of year"
        assert(actual().dayOfYear == expected) { message }
        return this
    }

    override fun beDayOfWeek(expected: DayOfWeek): DateShould<LocalDate> {
        val message = "${actual()} should be $expected day of week"
        assert(actual().dayOfWeek == expected) { message }
        return this
    }

    override fun isInFirstQuoter(): DateShould<LocalDate> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInSecondQuoter(): DateShould<LocalDate> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInThirdQuoter(): DateShould<LocalDate> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isInFourthQuoter(): DateShould<LocalDate> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun beInLeapYear(): DateShould<LocalDate> {
        val message = "${actual()} should be in leap year"
        assert(actual().isLeapYear) { message }
        return this
    }
}