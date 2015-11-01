package com.acme.edu;

/**
 * Very based simple realization of logger interface. Just print primitive types and objects.toString()
 */
public class SimpleLogger implements Logger {


    @Override
    public void log(int message) {
        print(message);
    }

    @Override
    public void log(byte message) {
        this.log((int)message);
    }

    @Override
    public void log(String message) {
        print(message);
    }

    @Override
    public void close() {

    }

    @Override
    public void log(boolean message) {
        print(message);
    }

    @Override
    public void log(char message) {
        print(message);
    }

    @Override
    public void log(Object message) {
        print(message);
    }

    @Override
    public void log(int... arr) {
        print(arr);
    }

    @Override
    public void log(int[][] arr) {
        print(arr);
    }

    @Override
    public void log(int[][][][] arr) {
        print(arr);
    }

    @Override
    public void log(String... arr) {
        print(arr);
    }

    private void print(Object message){
        System.out.println(message);
    }

    private void print(int message){
        System.out.println(message);
    }

    private void print(boolean message){
        System.out.println(message);
    }

    private void print(char message){
        System.out.println(message);
    }

}
