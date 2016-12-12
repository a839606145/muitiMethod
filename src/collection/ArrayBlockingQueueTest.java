package collection;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
	
	public static void main(String args[]){
		ArrayBlockingQueue<String> a=new ArrayBlockingQueue<String>(3);
		try {
			a.put(1+"a");
			a.put(2+"a");
			a.put(3+"a");
			a.put(4+"a");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
