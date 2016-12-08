package concurrent.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	public String call() throws Exception {
		int i=0;
		while(i==0){
			if(Thread.currentThread().isInterrupted()){
				throw new InterruptedException();
			}else{
				System.out.println(Thread.currentThread().getName()+"执行");
			}
		}
		return Thread.currentThread().getName();
	}

}
