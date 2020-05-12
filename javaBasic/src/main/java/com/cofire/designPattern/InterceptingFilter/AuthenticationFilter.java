package com.cofire.designPattern.InterceptingFilter;

public class AuthenticationFilter implements Filter {
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
