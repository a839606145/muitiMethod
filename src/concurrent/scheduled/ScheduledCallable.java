package concurrent.scheduled;

import java.util.concurrent.Callable;

public class ScheduledCallable implements Callable<String>{

	public String call() throws Exception {
		try{
			System.out.println(Thread.currentThread().getName()+"执行开始");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName()+"执行结束");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Thread.currentThread().getName();
	}

}
