从上面的例子中可以看到：将线程操作的对象   线程进行分别说明
线程其实就是Thread 的对象
        ： （Thread的子类 以及 实现runnable的类 最后都是放在这个类的机制下运行）
        ： 这个类 的需要告诉它 它要运行的对象是什么
创建多个Thread 和 创建多个线程类对象是不同的：
      ThreadTest t=new ThreadTest();
  例如：new Thread(t,"C") new Thread(t,"D")
           这个就是创建了两个线程，一个线程类对象  因此这两个线程的调用过程中会公用同一个线程类中的对象
      ThreadTest t=new ThreadTest();    ThreadTest t2=new ThreadTest(); 
           这个就是创建了两个线程，两个线程类对象，他们就是在调用的时候各自使用各自线程类的对象，就是执行顺序不知
           线程执行run方法时，会对线程类中的变量备份使用，执行后写回
线程的常用方法：
sleep： 从运行状态----阻塞状态，时间到后，从阻塞状态--可执行状态
yeild： 从运行状态----（可执行状态）
join：   主线程等待状态
sleep()睡眠时，保持对象锁，仍然占有该锁；
wait()睡眠时，释放对象锁。
Obj.wait()，与Obj.notify()：
            必须要与synchronized(Obj)一起使用，
            也就是wait,与notify是针对已经获取了Obj锁进行操作，
            从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。
            从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。
            直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。
            相应的notify()就是对对象锁的唤醒操作。
            但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，
            自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
            这样就提供了在线程间同步、唤醒的操作。
      Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。
主线程：JVM调用程序main()所产生的线程。
当前线程：这个是容易混淆的概念。一般指通过Thread.currentThread()来获取的进程。
后台线程：指为其他线程提供服务的线程，也称为守护线程。JVM的垃圾回收线程就是一个后台线程。用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束，
              守护线程 等主程序结束之后才结束。
前台线程：是指接受后台线程服务的线程，其实前台后台线程是联系在一起，就像傀儡和幕后操纵者一样的关系。傀儡是前台线程、幕后操纵者是后台线程。由前台线程创建的线程默认也是前台线程。可以通过isDaemon()和setDaemon()方法来判断和设置一个线程是否为后台线程。
线程类的一些常用方法： 
 
　　sleep(): 强迫一个线程睡眠Ｎ毫秒。 
　　isAlive(): 判断一个线程是否存活。 
　　join(): 等待线程终止。 
　　activeCount(): 程序中活跃的线程数。 
　　enumerate(): 枚举程序中的线程。 
    currentThread(): 得到当前线程。 
　　isDaemon(): 一个线程是否为守护线程。 
　　setDaemon(): 设置一个线程为守护线程。(用户线程和守护线程的区别在于，是否等待主线程依赖于主线程结束而结束) 
　　setName(): 为线程设置一个名称。 
　　wait(): 强迫一个线程等待。 
　　notify(): 通知一个线程继续运行。 
　　setPriority(): 设置一个线程的优先级。      
 注意：
    不同的对象实例的synchronized方法是不相干扰的（synchronized static对静态方法的同步）
    同一对象的synchronized方法是互斥的（synchronized static对静态方法的同步）
  synchronized关键字是不能继承的
  synchronized(this)
  
传递参数：
（1）构造方法
（2）普通方法
（3）使用对象
 
  
   
    

