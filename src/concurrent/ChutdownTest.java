package concurrent;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch 等待执行某一个数目的程序后，执行下面的程序
 * 它到底是怎么计算的是根据countDown的执行次数算的
 * @author Administrator
 *
 */
public class ChutdownTest {
 private static int sise=5;
 private static CountDownLatch doneSignal;
 public static void main(String args[]){
	 try {
		 doneSignal=new CountDownLatch(sise);
		 for(int i=0;i<10;i++){
			 new InnerThread(i).start(); 
		 }
		doneSignal.await();
		System.out.println("5个执行结束");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 static class InnerThread extends Thread{
	 private int name;
	 public InnerThread(int name){
		 super();
		 this.name=name;
		 this.setName(name+"");
	 }
	 public void run(){
		 try{
			 Thread.sleep(100);
			 System.out.println(Thread.currentThread().getName()+"执行");
			 if(name%2==0){
				 doneSignal.countDown();
			 }
		 }catch (Exception e) {
			 
		}
	 }
 }
}
