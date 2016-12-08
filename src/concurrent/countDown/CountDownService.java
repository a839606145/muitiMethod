package concurrent.countDown;

import java.util.concurrent.CountDownLatch;

public class CountDownService {

	private CountDownLatch come;
	private CountDownLatch ready;
	private CountDownLatch end;
	public CountDownService(CountDownLatch come,CountDownLatch ready,CountDownLatch end){
		this.come=come;
		this.ready=ready;
		this.end=end;
	}
	
	public void come(){
		try{
			System.out.println(Thread.currentThread().getName()+" comming");
			come.countDown();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ready(){
		try{
			come.await();
			System.out.println(Thread.currentThread().getName()+" ready");
			ready.countDown();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void end(){
		try{
			ready.await();
			System.out.println(Thread.currentThread().getName()+" end");
			end.countDown();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
