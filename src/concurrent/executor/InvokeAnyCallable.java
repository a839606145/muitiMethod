package concurrent.executor;

import java.util.concurrent.Callable;

public class InvokeAnyCallable implements Callable<String>{

	private int count=10;
	public String call() throws Exception{
			while(count>0){
				/*if(Thread.currentThread().isInterrupted()){
					throw new InterruptedException();
				}else{*/
					System.out.println(Thread.currentThread().getName()+"数据："+count+"执行");
					count--;
					try{
						if(Thread.currentThread().getName().equals("pool-1-thread-2")){
							Integer.parseInt("A");
						}
					}catch (Exception e) {
						throw new Exception();	
					}
				//}
				/*if(Thread.currentThread().getName().equals("pool-1-thread-2")){
					try{
						Integer.parseInt("A");
					}catch (Exception e) {
						e.printStackTrace();
					}
					Thread.currentThread().sleep(2);
				}*/
		}
		return Thread.currentThread().getName();
	}

}
