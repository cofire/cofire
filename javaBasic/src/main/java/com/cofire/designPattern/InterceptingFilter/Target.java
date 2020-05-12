package com.cofire.designPattern.InterceptingFilter;

public class Target {
    public void execute(String request) {
        System.out.println("Executing request: " + request);
    }
}
