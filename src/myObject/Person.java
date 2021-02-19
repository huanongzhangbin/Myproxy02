package myObject;

import myInterfaces.Speakable;

//目标类
public class Person implements Speakable {
    @Override
    public String  speak() {
       return "Hello";
    }
}
