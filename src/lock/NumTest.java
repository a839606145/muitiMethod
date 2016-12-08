package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumTest implements Runnable{
	private static int num=10;
	Lock lock=new ReentrantLock(); //这个锁必须的共有
	public void run() {
			while(true){
					try{
						lock.lockInterruptibly();
						System.out.println(Thread.currentThread().getName()+"获得锁");
						if(num>0){
							System.out.println(Thread.currentThread().getName()+":"+num);
							num--;
						}else{
							break;
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally{
						lock.unlock();
					}
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
	}
	
	public static void main(String args[]){
		NumTest a=new NumTest();
		new Thread(a,"A").start();
		Thread b=new Thread(a,"B");
		b.start();
		try {
			Thread.sleep(20);
			b.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
