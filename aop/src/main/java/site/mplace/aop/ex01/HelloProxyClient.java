package site.mplace.aop.ex01;

import java.lang.reflect.Proxy;


public class HelloProxyClient {
  public static void main (String[] args){
    Class[] arrClass = {HelloWorld.class};

    HelloWorld helloWorld = new HelloworldImpl();
    HelloWorldHandler<HelloWorld> handler = new HelloWorldHandler<>(helloWorld);

    // proxy : 대리
    HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(HelloWorld.class.getClassLoader(),arrClass,handler);
    proxy.sayHello("새똥이");
  }
}
