package concurrent.test;

import java.util.concurrent.Semaphore;

public class Service {
  private Semaphore sem;
  public Service(Semaphore sem){
	  this.sem=sem;
  }
  public void testMethod(){
	  try{
		  sem.acquire();
		  System.out.println(Thread.currentThread().getName()+":"+System.currentTimeMillis());
		  sem.release();
	  }catch (Exception e) {
		e.printStackTrace();
	}
  }
}
