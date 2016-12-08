package concurrent.countDown;

import java.util.concurrent.CountDownLatch;
/**
 * 注意 对与每一个执行的线程 在线程内部也要实现 等待 以免自己做自己的了
 * @author Administrator
 *
 */
public class CountDownSreviceTest {
  public static void main(String args[]) throws Exception{
	   CountDownLatch come=new CountDownLatch(10);
	   CountDownLatch ready=new CountDownLatch(10);
		CountDownLatch end=new CountDownLatch(10);
	  CountDownService service=new CountDownService(come, ready, end);
	  CountDownServiceThread[] t=new CountDownServiceThread[10];
	  for(int i=0;i<10;i++){
		  t[i]=new CountDownServiceThread(service);
		  t[i].start();
	  }
	  System.out.println("裁判等待到来");
	  come.await();
	  System.out.println("都来了");
	  ready.await();
	  System.out.println("准备好了");
	  end.await();
	  System.out.println("结束了");
	  
  }
}
