package collection;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {

	public static void main(String args[]){
		ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<String>();
		new Thread2(queue).start();
		new Thread1(queue).start();
		
	}
	
	static class Thread2 extends Thread{
		private ConcurrentLinkedQueue<String> queue;
		public Thread2(ConcurrentLinkedQueue<String> queue){
			this.queue=queue;
		}
		
		public void run(){
			for(int i=0;i<10;i++){
				queue.add("hello"+i);
				System.out.println("put "+i);
			}
		}
	}
	
	static class Thread1 extends Thread{
		private ConcurrentLinkedQueue<String> queue;
		public Thread1(ConcurrentLinkedQueue<String> queue){
			this.queue=queue;
		}
		
		public void run(){
			while(!queue.isEmpty()){
				System.out.println(queue.poll());
			}
		}
	}
}
