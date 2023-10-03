package com.vd.study.java_code.container;

import org.junit.Assert;
import org.junit.Test;

public class ResultTest {

    @Test
    public void getOrNullFunctionInCorrectComponent_AfterFunctionCalling_ReturnCorrectValue() {
        Result<String> correctObject = new Result.Correct<>("TEST");

        String result = correctObject.getOrNull();

        Assert.assertEquals("TEST", result);
    }

    @Test
    public void getOrExceptionFunctionInCorrectComponent_AfterFunctionCalling_ReturnCorrectValue() throws Exception {
        Result<String> correctObject = new Result.Correct<>("TEST");

        String result = correctObject.getOrException();

        Assert.assertEquals("TEST", result);
    }

    @Test
    public void getOrNullFunctionInProgressComponent_AfterFunctionCalling_ReturnNull() {
        Result<Void> progressObject = new Result.Progress<>();

        Void result = progressObject.getOrNull();

        Assert.assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOrExceptionFunctionInProgressComponent_AfterFunctionCalling_throwIllegalArgumentException() throws Exception {
        Result<Void> progressObject = new Result.Progress<>();

        progressObject.getOrException();
    }

    @Test
    public void getOrNullFunctionInErrorComponent_AfterFunctionCalling_ReturnNull() {
        Result<Void> errorObject = new Result.Error<>(new IllegalArgumentException());

        Void result = errorObject.getOrNull();

        Assert.assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOrExceptionFunctionInErrorComponent_AfterFunctionCalling_throwIllegalArgumentException() throws Exception {
        Result<Void> errorObject = new Result.Error<>(new IllegalArgumentException());

        errorObject.getOrException();
    }
}