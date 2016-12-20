package thread;

import java.util.Date;

public class ThreadSleepTest extends Thread{
    private MyService myService;
    public ThreadSleepTest(MyService myService){
    	super();
    	this.myService=myService;
    }
	public void run(){
		try{
			if(Thread.currentThread().getName().equals("Thread-0")){
				myService.start();
			}else{
				myService.notify1();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static class MyService{
		public  synchronized void start(){
			try {
				System.out.println(Thread.currentThread().getName()+""+new Date().getTime());
				//this.wait();
				Thread.currentThread().sleep(200);
				System.out.println(Thread.currentThread().getName()+""+new Date().getTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public  synchronized void notify1(){
			try {
				System.out.println(Thread.currentThread().getName()+""+new Date().getTime());
				//this.notify();
				Thread.currentThread().sleep(200);
				System.out.println(Thread.currentThread().getName()+""+new Date().getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	public static void main(String args[]){
		MyService service=new MyService();
		ThreadSleepTest t1=new ThreadSleepTest(service);
		ThreadSleepTest t2=new ThreadSleepTest(service);
		t1.start();
		t2.start();
	}
	
}
