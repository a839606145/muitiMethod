package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorTest implements Runnable{
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
		ExecutorService service=Executors.newFixedThreadPool(2);
		ExecutorTest a=new ExecutorTest();
		for(int i=0;i<2;i++){
			service.execute(a);
		}
		service.shutdown(); //必须显示shutdown 要不程序不关闭
	}

}
