package concurrent.countDown;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch 的计数不能修改
 * await() 等待计数为0，线程阻塞
 * countDown() 计数减少
 * @author Administrator
 *
 */
public class CountDownTest {
	public static void main(String args[]){
		CountDownLatch count=new CountDownLatch(10);
		for(int i=0;i<10;i++){
			new CountDownThread(count).start();
		}
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("all comming");
	}

}
