package concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InvokerAnyTest {
  public static void main(String args[]){
	  ThreadPoolExecutor service=new ThreadPoolExecutor(2, 2, 5, TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>());
	  
	  List<InvokeAnyCallable> l=new ArrayList<InvokeAnyCallable>();
	  for(int i=0;i<2;i++){
		  InvokeAnyCallable list1=new InvokeAnyCallable();
		  l.add(list1);
	  }
	  try {
		List<Future<String>> res=service.invokeAll(l);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).get());
		}
	} catch (InterruptedException e) {
		System.out.println(Thread.currentThread().getName()+"被中断了");
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
}
