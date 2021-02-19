# 动态代理的实例
怕自己忘记，所以记录一下

      2. jdk动态代理的实现
		   反射包 java.lang.reflect , 里面有三个类 ： InvocationHandler , Method, Proxy.
			1)InvocationHandler 接口（调用处理器）：就一个方法invoke（）
			   invoke（）:表示代理对象要执行的功能代码。你的代理类要完成的功能就写在
				            invoke()方法中。

								代理类完成的功能：
								 1. 调用目标方法，执行目标方法的功能
								 2. 功能增强，在目标方法调用时，增加功能。  


         方法原型：
			参数： Object proxy:jdk创建的代理对象，无需赋值。
			        Method method:目标类中的方法，jdk提供method对象的
                 Object[] args：目标类中方法的参数， jdk提供的。

		   public Object invoke(Object proxy, Method method, Object[] args)

         InvocationHandler 接口：表示你的代理要干什么。
			怎么用： 1.创建类实现接口InvocationHandler
			          2.重写invoke（）方法， 把原来静态代理中代理类要完成的功能，写在这。

       
       2）Method类：表示方法的， 确切的说就是目标类中的方法。
		    作用：通过Method可以执行某个目标类的方法，Method.invoke();
			        method.invoke(目标对象，方法的参数)
					  Object ret = method.invoke(service2, "李四");

		    说明： method.invoke（）就是用来执行目标方法的，等同于静态代理中的
			         //向厂家发送订单，告诉厂家，我买了u盘，厂家发货
                  float price = factory.sell(amount); //厂家的价格。


		 3）Proxy类：核心的对象，创建代理对象。之前创建对象都是 new 类的构造方法()
		       现在我们是使用Proxy类的方法，代替new的使用。 

			方法： 静态方法 newProxyInstance() 
			作用是： 创建代理对象， 等同于静态代理中的TaoBao taoBao = new TaoBao();


         参数：
			 1. ClassLoader loader 类加载器，负责向内存中加载对象的。 使用反射获取对象的ClassLoader
			      类a , a.getCalss().getClassLoader(),  目标对象的类加载器
		         2. Class<?>[] interfaces： 接口， 目标对象实现的接口，也是反射获取的。
                         3. InvocationHandler h : 我们自己写的，代理类要完成的功能。 

			返回值：就是代理对象

			public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)  


									
  3. 实现动态代理的步骤：
    1. 创建接口，定义目标类要完成的功能
	 2. 创建目标类实现接口
	 3. 创建InvocationHandler接口的实现类，在invoke方法中完成代理类的功能
	     1.调用目标方法
             2.增强功能
	 4.使用Proxy类的静态方法，创建代理对象。 并把返回值转为接口类型。

