package com.cofire.designPattern.Visitor;

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
