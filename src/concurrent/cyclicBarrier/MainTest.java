package concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
/**
 * CyclicBarrier 等指定个数的线程都执行了await 则执行下面的操作
 * 具有屏障重置性 满了之后 重新计算 
 * @author Administrator
 *
 */
public class MainTest {

	public static void main(String args[]) throws Exception{
		CyclicBarrier c=new CyclicBarrier(5,new Runnable() {
			public void run() {
				System.out.println("完成");
			}
		});
		CyclicBarrierThread[] l=new CyclicBarrierThread[10];
		for(int i=0;i<10;i++){
			l[i]=new CyclicBarrierThread(c);
		}
		for(int i=0;i<10;i++){
			l[i].start();
		}
	}
}
