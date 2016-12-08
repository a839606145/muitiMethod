package concurrent.executor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executors 使用多工厂模式
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String args[]) throws Exception{
		//ExecutorService service=Executors.newFixedThreadPool(2); 固定个数的
		//ExecutorService service=Executors.newCachedThreadPool();
		//ThreadPoolExecutor service=new ThreadPoolExecutor(2,4,100,TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>(6));
		ThreadPoolExecutor service=new ThreadPoolExecutor(2,4,100,TimeUnit.MINUTES,new ArrayBlockingQueue(2));
		//service.setThreadFactory(new MyThreadFactory());
		service.setRejectedExecutionHandler(new MyRejectedException());
		for(int i=0;i<10;i++){
			service.execute(new MyThread());
			//System.out.println("核心线程"+service.prestartCoreThread());
		}
		service.shutdown();//正在运行的线程无影响
		Thread.sleep(200);
		System.out.println(service.getCompletedTaskCount());
		//List l=service.shutdownNow(); //
		//service.execute(new MyThread());
		/*System.out.println(service.isShutdown());
		System.out.println(service.isTerminating());
		System.out.println(service.isTerminated());
		//System.out.println(service.awaitTermination(1,TimeUnit.SECONDS));
		//System.out.println(l.size());
*/		System.out.println("main end");
	}
}
/*
service.execute(new Runnable(){

			public void run() {
				try{
					System.out.println("AAAA");
				}catch (Exception e) {
				}
			}
			
		});
		service.execute(new Runnable(){

			public void run() {
				try{
					System.out.println("BBB");
				}catch (Exception e) {
				}
			}
			
		});
		*/
