package io.fromsource.kiwi.core.number

import io.fromsource.kiwi.core.should
import kotlin.test.Test

@ExperimentalUnsignedTypes
class ULongShouldTest {

    @Test
    fun `should fail because numbers are not equaled`() {
        runCatching {
            more.should() beEqual less
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should == $less")
    }

    @Test
    fun `should guarantee numbers are equaled`() {
        more.should() beEqual more
    }

    @Test
    fun `should fail because number is not zero`() {
        runCatching {
            more.should().beZero()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should == $zero")
    }

    @Test
    fun `should guarantee that number is zero`() {
        zero.should().beZero()
    }

    @Test
    fun `should fail because number is not less or equal`() {
        runCatching {
            more.should() beLessOrEqualThan less
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should be <= $less")
    }

    @Test
    fun `should guarantee than number is less or equal`() {
        less.should() beLessOrEqualThan less
    }

    @Test
    fun `should fail because number is not greater or equal`() {
        runCatching {
            less.should() beGreaterOrEqualThan more
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$less should be >= $more")
    }

    @Test
    fun `should guarantee than number is greater or equal`() {
        less.should() beGreaterOrEqualThan less
    }

    @Test
    fun `should fail because number is not less`() {
        runCatching {
            more.should() beLessThan less
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should be < $less")
    }

    @Test
    fun `should guarantee than number is less`() {
        less.should() beLessThan more
    }

    @Test
    fun `should fail because number is not less than ubyte`() {
        runCatching {
            more.should() beLessThan less.toUByte()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should be < ${less.toUByte()}")
    }

    @Test
    fun `should guarantee than number is less than ubyte`() {
        less.should() beLessThan more.toUByte()
    }

    @Test
    fun `should fail because number is not less than ushort`() {
        runCatching {
            more.should() beLessThan less.toUShort()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should be < ${less.toUShort()}")
    }

    @Test
    fun `should guarantee than number is less than ushort`() {
        less.should() beLessThan more.toUShort()
    }

    @Test
    fun `should fail because number is not less than uint`() {
        runCatching {
            more.should() beLessThan less.toUInt()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should be < ${less.toUInt()}")
    }

    @Test
    fun `should guarantee than number is less than uint`() {
        less.should() beLessThan more.toUInt()
    }

    @Test
    fun `should fail because number is not greater than ubyte`() {
        runCatching {
            less.should() beGreaterThan more.toUByte()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$less should be > $more")
    }

    @Test
    fun `should guarantee than number is greater than ubyte`() {
        more.should() beGreaterThan less.toUByte()
    }

    @Test
    fun `should fail because number is not greater than ushort`() {
        runCatching {
            less.should() beGreaterThan more.toUShort()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$less should be > ${more.toUShort()}")
    }

    @Test
    fun `should guarantee than number is greater than ushort`() {
        more.should() beGreaterThan less.toUShort()
    }

    @Test
    fun `should fail because number is not greater`() {
        runCatching {
            less.should() beGreaterThan more
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$less should be > $more")
    }

    @Test
    fun `should guarantee than number is greater`() {
        more.should() beGreaterThan less
    }

    @Test
    fun `should fail because number is not greater than uint`() {
        runCatching {
            less.should() beGreaterThan more.toUInt()
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$less should be > ${more.toUInt()}")
    }

    @Test
    fun `should guarantee than number is greater than uint`() {
        more.should() beGreaterThan less.toUInt()
    }

    @Test
    fun `should fail because number is not between`() {
        runCatching {
            more.should().beBetween(zero, less)
        }.should()
                .beFailure(AssertionError::class)
                .haveFailureMessage("$more should be between ($zero .. $less)")
    }

    @Test
    fun `should guarantee number is between`() {
        less.should().beBetween(zero, more)
    }

    companion object {
        val zero = UInt.MIN_VALUE
        val less = 1.toUInt()
        val more = 10.toUInt()
    }
}