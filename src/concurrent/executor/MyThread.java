package concurrent.executor;

public class MyThread extends Thread{

	public void run(){
		try{
			System.out.println(Thread.currentThread().getName()+"执行");
			Thread.sleep(100);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
