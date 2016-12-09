package concurrent.scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledTest {
  public static void main(String args[]){
	  try{
		  List<ScheduledCallable> l=new ArrayList<ScheduledCallable>();
		  for(int i=0;i<5;i++){
			  l.add(new ScheduledCallable());
		  }
		 // ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		  //ScheduledExecutorService service=Executors.newScheduledThreadPool(2);
		  ScheduledThreadPoolExecutor service=new ScheduledThreadPoolExecutor(2);
		  service.scheduleAtFixedRate(new ScheduleRunnabale(),1,4, TimeUnit.SECONDS);
		  service.scheduleAtFixedRate(new ScheduleRunnabale(),1,4, TimeUnit.SECONDS);
		  service.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
		  Thread.sleep(1000);
		  service.shutdown();
		 // ScheduledFuture<String> F2=service.schedule(l.get(1),4L, TimeUnit.SECONDS);
		 // System.out.println(F1.get());
		 // System.out.println(F2.get());
	  }catch (Exception e) {
		  e.printStackTrace();
	}
  }
}
