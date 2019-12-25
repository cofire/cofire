package com.cofire.basic.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ly
 * @Description
 * @date 2019/12/23
 **/
public class ReflexTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person();
        person.setName("李应");
        Field field = person.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        field.set(person, "18721367130");
        System.out.println(person.toString());

        Person person2 = new Person();
        person2.setName("李应");
        Method setPhone = person2.getClass().getDeclaredMethod("setPhone", String.class);
        setPhone.setAccessible(true);
        setPhone.invoke(person2, "18721345678");
        System.out.println(person2.toString());
    }
}

class Person {
    private String name;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + phone;
    }
}
