package com.cofire.designPattern.Singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {

        // ���Ϸ��Ĺ��캯��
        // ����ʱ���󣺹��캯�� SingleObject() �ǲ��ɼ���
        // SingleObject object = new SingleObject();

        // ��ȡΨһ���õĶ���
        SingleObject object = SingleObject.getInstance();

        // ��ʾ��Ϣ
        object.showMessage();
    }
}
