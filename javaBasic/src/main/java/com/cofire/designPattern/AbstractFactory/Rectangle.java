package com.cofire.designPattern.AbstractFactory;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.err.println("Inside Rectangle::draw() method.");
    }
}
