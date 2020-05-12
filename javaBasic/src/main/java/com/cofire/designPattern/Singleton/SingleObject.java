package com.cofire.designPattern.Singleton;

public class SingleObject {

    // ���� SingleObject ��һ������
    private static SingleObject instance = new SingleObject();

    // �ù��캯��Ϊ private����������Ͳ��ᱻʵ����
    private SingleObject() {
    }

    // ��ȡΨһ���õĶ���
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
