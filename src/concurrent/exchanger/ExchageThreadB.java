package concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchageThreadB  extends Thread{

	private Exchanger<String> exchanger;
	public ExchageThreadB(Exchanger<String> exchanger){
		super();
		this.exchanger=exchanger;
	}
	public void run(){
		try{
			System.out.println("A给的值"+exchanger.exchange("B"));
			System.out.println("B end");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
