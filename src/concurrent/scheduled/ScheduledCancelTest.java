package concurrent.scheduled;

import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledCancelTest {
	
	public static void main(String args[]){
		try{
			ScheduledThreadPoolExecutor service=new ScheduledThreadPoolExecutor(10);
			ScheduledFuture f=service.schedule(new ScheduleRunnabale(),300,TimeUnit.SECONDS);
			System.out.println(f.cancel(true));
			BlockingQueue<Runnable> queue=service.getQueue();
			Iterator<Runnable> it=queue.iterator();
			while(it.hasNext()){
				System.out.println("队列中"+it.next());
			}
			
			
		}catch (Exception e) {
		}
	}

}
