package com.cofire.designPattern.AbstractFactory;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }

}
