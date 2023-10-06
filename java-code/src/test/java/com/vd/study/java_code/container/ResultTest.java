package com.vd.study.java_code.container;

import org.junit.Assert;
import org.junit.Test;

public class ResultTest {

    @Test
    public void mapProgress_AfterMapping_ReturnNewProgressObject() {
        Result<Integer> result = new Result.Progress<>();

        Result<String> newObject = result.map(String::valueOf);

        Assert.assertTrue(newObject instanceof Result.Progress);
    }

    @Test(expected = Exception.class)
    public void mapError_AfterMapping_ReturnNewErrorObject() throws Exception {
        Result<Integer> result = new Result.Error<>(new IllegalArgumentException("EXCEPTION"));

        Result<String> newObject = result.map(String::valueOf);

        Assert.assertTrue(newObject instanceof Result.Error);
        Assert.assertNull(newObject.getOrNull());
        newObject.getOrException();
    }

    @Test
    public void mapCorrect_AfterMapping_ReturnNewCorrectObjectWithNewType() throws Exception {
        Result<Integer> result = new Result.Correct<>(12345);

        Result<String> newObject = result.map(String::valueOf);

        Assert.assertTrue(newObject instanceof Result.Correct);
        Assert.assertEquals("12345", newObject.getOrNull());
        Assert.assertEquals("12345", newObject.getOrException());
    }

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