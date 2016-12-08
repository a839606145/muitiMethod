package concurrent.exchanger;

import java.util.concurrent.Exchanger;
/**
 * 两个线程之间互换信息 
 * 当一个线程调用exchanger的时候，她就阻塞了，她等另一个线程也调用exchange ，两个都调用了，就会各自得到数据
 *继续执行
 * @author Administrator
 *
 */
public class MainTest {
	
	public static void main(String args[]){
		Exchanger<String> exchanger=new Exchanger<String>();
		ExchangeThread t=new ExchangeThread(exchanger);
		ExchageThreadB B=new ExchageThreadB(exchanger);
		t.start();
		B.start();
		System.out.println("main end");
	}

}
