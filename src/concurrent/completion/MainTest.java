package concurrent.completion;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainTest {
 public static void main(String args[]) throws Exception{
	 ThreadPoolExecutor service=new ThreadPoolExecutor(2, 3, 100, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
	 MyCallable[] list=new MyCallable[10];
	 CompletionService ser=new ExecutorCompletionService(service);
	 for(int i=0;i<10;i++){
		 list[i]=new MyCallable();
		 ser.submit(list[i]);
	 }
	 
	 for(int i=0;i<10;i++){
		// System.out.println(ser.take().get());
		 System.out.println(ser.poll());
	 }
	 
	 service.shutdown();
 }
}
