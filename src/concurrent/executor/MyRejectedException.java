package concurrent.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectedException implements RejectedExecutionHandler{

	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(((MyThread)r).getName()+"rejected");
	}

}
