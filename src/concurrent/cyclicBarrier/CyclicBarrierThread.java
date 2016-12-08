package concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread{
 private CyclicBarrier barrier;
 public CyclicBarrierThread(CyclicBarrier barrier){
	 super();
	 this.barrier=barrier;
 }
 public void run(){
	 try{
		 System.out.println(Thread.currentThread().getName()+" coming");
		 barrier.await();
	 }catch (Exception e) {
		e.printStackTrace();
	}
 }
}
