package concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangeThread extends Thread{
	private Exchanger<String> exchanger;
	public ExchangeThread(Exchanger<String> exchanger){
		super();
		this.exchanger=exchanger;
	}
	public void run(){
		try{
			System.out.println("在线程中得到另一个线程的值为"+exchanger.exchange("中国人"));
			System.out.println("A end");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
