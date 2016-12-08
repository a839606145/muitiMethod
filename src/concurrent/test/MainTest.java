package concurrent.test;

import java.util.concurrent.Semaphore;

public class MainTest {
	
	public static void main(String args[]){
		Service s=new Service(new Semaphore(3));
		ThreadTest a=new ThreadTest(s); 
		ThreadTest b=new ThreadTest(s);
		a.start();
		b.start();
		
	}

}
