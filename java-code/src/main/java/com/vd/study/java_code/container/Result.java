package com.vd.study.java_code.container;

public abstract class Result<T> {


    public abstract T getOrNull();

    public abstract T getOrException() throws Exception;

    static final class Progress<T> extends Result<T> {

        @Override
        public T getOrNull() {
            return null;
        }

        @Override
        public T getOrException() {
            throw new IllegalArgumentException("This component has not a value");
        }
    }

    static final class Error<T> extends Result<T> {

        private final Exception exception;

        public Error(Exception exception) {
            this.exception = exception;
        }

        @Override
        public T getOrNull() {
            return null;
        }

        @Override
        public T getOrException() throws Exception {
            throw exception;
        }
    }

    static final class Correct<T> extends Result<T> {

        private final T value;

        public Correct(T value) {
            this.value = value;
        }

        @Override
        public T getOrNull() {
            return value;
        }

        @Override
        public T getOrException() {
            return value;
        }
    }
}