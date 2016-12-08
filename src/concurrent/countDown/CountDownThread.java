package concurrent.countDown;

import java.util.concurrent.CountDownLatch;

public class CountDownThread extends Thread{
  private CountDownLatch countDown;
  public CountDownThread(CountDownLatch countDown){
	  super();
	  this.countDown=countDown;
  }
  public void run(){
	  try{
		  System.out.println(Thread.currentThread().getName()+"I am comming");
		  countDown.countDown();
	  }catch (Exception e) {
		e.printStackTrace();
	}
  }
}
