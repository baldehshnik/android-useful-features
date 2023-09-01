package com.vd.study.java_code.container;

import org.junit.Assert;
import org.junit.Test;

public class ResultTest {

    @Test
    public void correctExceptionValue_AfterErrorObjectCreation_ContainsTheSameObject() {
        Exception exception = new IllegalArgumentException("EXCEPTION");
        Result.Error errorObject = new Result.Error(exception);

        Assert.assertEquals(exception, errorObject.getException());
    }

    @Test
    public void getOrNullFunctionInCorrectComponent_AfterFunctionCalling_ReturnCorrectValue() {
        Result.Correct<String> correctObject = new Result.Correct<>("TEST");

        String result = correctObject.getOrNull();

        Assert.assertEquals("TEST", result);
    }

    @Test
    public void getOrExceptionFunctionInCorrectComponent_AfterFunctionCalling_ReturnCorrectValue() {
        Result.Correct<String> correctObject = new Result.Correct<>("TEST");

        String result = correctObject.getOrException();

        Assert.assertEquals("TEST", result);
    }

    @Test
    public void getOrNullFunctionInProgressComponent_AfterFunctionCalling_ReturnNull() {
        Result.Progress progressObject = new Result.Progress();

        Void result = progressObject.getOrNull();

        Assert.assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOrExceptionFunctionInProgressComponent_AfterFunctionCalling_throwIllegalArgumentException() {
        Result.Progress progressObject = new Result.Progress();

        progressObject.getOrException();
    }

    @Test
    public void getOrNullFunctionInErrorComponent_AfterFunctionCalling_ReturnNull() {
        Result.Error errorObject = new Result.Error(new IllegalArgumentException());

        Void result = errorObject.getOrNull();

        Assert.assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOrExceptionFunctionInErrorComponent_AfterFunctionCalling_throwIllegalArgumentException() throws Exception {
        Result.Error errorObject = new Result.Error(new IllegalArgumentException());

        errorObject.getOrException();
    }
}