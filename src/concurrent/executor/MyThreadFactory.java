package concurrent.executor;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t=new Thread(r);
		t.setName("hhh"+System.currentTimeMillis());
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() { //自定义异常处理
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("自定义异常");
			}
		});
		return t;
	}

}
