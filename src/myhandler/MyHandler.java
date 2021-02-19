package myhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


//调用处理器
public class MyHandler implements InvocationHandler {//实现固定接口
    Object target;//目标对象

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Object res=null;
      res=method.invoke(target, args);//调用目标方法

      if(res!=null){
          System.out.println("新年快乐  "+(String)res);//方法增强
      }
     return res;
    }
}
