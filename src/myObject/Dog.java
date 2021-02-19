package myObject;

import myInterfaces.Speakable;
//目标类
public class Dog implements Speakable {
    @Override
    public String speak() {
        return "旺旺";
    }
}
