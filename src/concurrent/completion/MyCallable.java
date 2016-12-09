package concurrent.completion;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"执行完成");
		return Thread.currentThread().getName();
	}

}
