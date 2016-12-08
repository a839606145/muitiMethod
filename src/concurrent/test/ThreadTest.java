package concurrent.test;

public class ThreadTest extends Thread{
	  private Service service;
	  public ThreadTest(Service service){
		  this.service=service;
	  }
	  public void run(){
		  service.testMethod();
	  }
}
