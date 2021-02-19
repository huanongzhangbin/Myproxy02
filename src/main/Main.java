package main;

import myInterfaces.Speakable;
import myObject.Dog;
import myObject.Person;
import myhandler.MyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //目标对象
        Speakable dogspeak=new Dog();

        //传入调用处理器
        InvocationHandler doghandler=new MyHandler(dogspeak);

        //获取代理对象
         Speakable dogproxy =(Speakable)Proxy.newProxyInstance(dogspeak.getClass().getClassLoader(),
                dogspeak.getClass().getInterfaces(),
                doghandler);
         //调用方法
        dogproxy.speak();


        Speakable personspeak =new Person();
        InvocationHandler personhandler=new MyHandler(personspeak);
        Speakable personproxy=(Speakable) Proxy.newProxyInstance(personspeak.getClass().getClassLoader(),
                personspeak.getClass().getInterfaces(),
                personhandler);
        personproxy.speak();
    }
}
