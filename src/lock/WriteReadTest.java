package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadTest {
	ReentrantReadWriteLock writeLock=new ReentrantReadWriteLock();
	private int nu=10;
	public class readClass implements Runnable{
		public void run() {
			while(true){
				try{
					writeLock.readLock().lock();
					if(nu>0){
						System.out.println(Thread.currentThread().getName()+"读"+nu);
					}else{
						break;
					}
				}finally{
					writeLock.readLock().unlock();
				}
			}
		}
	}
	
	public class writeClass implements Runnable{
		public void run() {
			while(true){
				try{
					writeLock.writeLock().lock();
					if(nu>0){
						System.out.println(Thread.currentThread().getName()+"写"+nu);
						nu--;
					}else{
						break;
					}
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}finally{
					writeLock.writeLock().unlock();
				}
			}
		}
	}
   public static void main(String args[]){
	   WriteReadTest t=new WriteReadTest();
	   WriteReadTest.readClass r1=t.new readClass(); //创建的特殊性
	   WriteReadTest.readClass r2=t.new readClass();
	   WriteReadTest.writeClass w1=t.new writeClass();
	   new Thread(r1,"r1").start();
	   new Thread(r2,"r2").start();
	   new Thread(w1,"w1").start();
	   
	  
   }

}
