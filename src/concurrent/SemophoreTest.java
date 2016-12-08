package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * 信号量 acquire relesase 可以设置参数 release 同时也能实现 添加许可数功能
 * 可是使用acquireUninterruptibly 控制等待的线程不能被中断
 * availablePermits  drainPermits
 * getQueueLength  hasQueuedThreads
 * @author Administrator
 *
 */
public class SemophoreTest implements Runnable{
    private int num=10;
    private Semaphore sem;
    public SemophoreTest(Semaphore sem){
    	this.sem=sem;
    }
	public void run() {
		try{
			while(true){
				if(sem.availablePermits()>0){
					System.out.println(Thread.currentThread().getName()+"可以得到锁");
					sem.acquire();
					System.out.println(Thread.currentThread().getName()+"得到锁");
					if(num>0){
						System.out.println(Thread.currentThread().getName()+":"+num);
						num--;
						sem.release();
					}else{
						sem.release();
						break;
					}
				}else{
					System.out.println(Thread.currentThread().getName()+"得不到锁");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		ExecutorService list=Executors.newCachedThreadPool();
		    Semaphore position=new Semaphore(1);
		    SemophoreTest a=new SemophoreTest(position);
		    for(int i=0;i<10;i++){
		     list.submit(a);
		    }
		    list.shutdown();
		    position.acquireUninterruptibly(1);
		    System.out.println("使用完毕，需要清扫了");
		    position.release(1);
		    
	}

}
