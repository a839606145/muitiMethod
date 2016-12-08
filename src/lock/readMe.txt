Lock可以使用Condition进行线程之间的调度,使用condition signal 以及 wait 方法
Synchronized则使用Object对象本身的notify, wait, notityAll调度机制
//接口 类说明 使用java.util.concurrent 包
Lock-含有方法 lock tryLock lockInterruptibly  unLock 等
     实现类 ReentrantLock
ReadWriteLock 接口含有两个Lock方法（Lock readLock();  Lock WriteLock() ）
     实现类有：ReentrantReadWriteLock,含有内部类 ReadLock WriteLock
ReentrantLock 可以使用公平锁 或者非公平锁
   lock tryLock的区别：tryLock 直接返回行不行
                      lock是不行就等待，等待不会中断
                      lockInterruptibly是不行就等待，等待可中断,

     
     
