package com.vd.study.kotlin_code.container

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ResultTest {

    @Test
    fun correctExceptionValue_AfterErrorObjectCreation_ContainsTheSameObject() {
        val exception = IllegalArgumentException("EXCEPTION")
        val errorObject = Result.Error(exception)

        assertEquals(exception, errorObject.exception)
    }

    @Test
    fun mapFunctionInProgressComponent_AfterFunctionCalling_ReturnTheSameObject() {
        val progressObject = Result.Progress

        val result = progressObject.map {}

        assertEquals(progressObject, result)
    }

    @Test
    fun mapFunctionInErrorComponent_AfterFunctionCalling_ReturnTheSameObject() {
        val exception = IllegalArgumentException()
        val errorObject = Result.Error(exception)

        val result = errorObject.map {}

        assertEquals(errorObject, result)
    }

    @Test
    fun mapFunctionInCorrectComponent_AfterFunctionCalling_ReturnObjectWithNewValueType() {
        val correctObject = Result.Correct("890")

        val result = correctObject.map { it.toInt() }

        assertEquals(890, result.getOrException())
    }

    @Test
    fun mapFunctionInCorrectComponent_AfterFunctionCalling_ReturnErrorComponent() {
        val correctObject = Result.Correct("TEST")

        val result = correctObject.map { it.toInt() }

        assertTrue(result is Result.Error)
    }

    @Test
    fun getOrNullFunctionInCorrectComponent_AfterFunctionCalling_ReturnCorrectValue() {
        val correctObject = Result.Correct("TEST")

        val result = correctObject.getOrNull()

        assertEquals("TEST", result)
    }

    @Test
    fun getOrExceptionFunctionInCorrectComponent_AfterFunctionCalling_ReturnCorrectValue() {
        val correctObject = Result.Correct("TEST")

        val result = correctObject.getOrException()

        assertEquals("TEST", result)
    }

    @Test
    fun getOrNullFunctionInProgressComponent_AfterFunctionCalling_ReturnNull() {
        val progressObject = Result.Progress

        val result = progressObject.getOrNull()

        assertNull(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun getOrExceptionFunctionInProgressComponent_AfterFunctionCalling_throwIllegalArgumentException() {
        val progressObject = Result.Progress

        progressObject.getOrException()
    }

    @Test
    fun getOrNullFunctionInErrorComponent_AfterFunctionCalling_ReturnNull() {
        val errorObject = Result.Error(IllegalArgumentException())

        val result = errorObject.getOrNull()

        assertNull(result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun getOrExceptionFunctionInErrorComponent_AfterFunctionCalling_throwIllegalArgumentException() {
        val errorObject = Result.Error(IllegalArgumentException())

        errorObject.getOrException()
    }
}