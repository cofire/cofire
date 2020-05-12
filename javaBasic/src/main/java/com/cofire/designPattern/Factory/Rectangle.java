package com.cofire.designPattern.Factory;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.err.println("Inside Rectangle::draw() method.");
    }
}
