package concurrent.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {
  public static void main(String args[]) throws Exception{
	  MyCallable call=new MyCallable();
	  ThreadPoolExecutor service=new ThreadPoolExecutor(2, 3, 4, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>());
	  Future f=service.submit(call);
	  Thread.sleep(200);
	  System.out.println(f.get(20,TimeUnit.MINUTES));
	 // System.out.println("中断:"+f.cancel(true));
	 // System.out.println("Fanhui :"+f.get());
	 // System.out.println("是否中断"+f.isCancelled());
	  /*Future f2=service.submit(call);
	  Future f3=service.submit(call);
	  Future f4=service.submit(call);
	  System.out.println("Fanhui :"+f2.get());
	  System.out.println("Fanhui :"+f3.get());
	  System.out.println("Fanhui :"+f4.get());*/
	  
  }
}
