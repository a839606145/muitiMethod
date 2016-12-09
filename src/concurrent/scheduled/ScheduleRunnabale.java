package concurrent.scheduled;

public class ScheduleRunnabale implements Runnable{

	public void run() {
		try{
			System.out.println(Thread.currentThread().getName()+"执行开始");
			System.out.println(Thread.currentThread().getName()+"执行结束");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
