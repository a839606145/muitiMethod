package collection;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	static class PutThread extends Thread{
		private SynchronousQueue queue;
		public PutThread(SynchronousQueue queue){
			super();
			this.queue=queue;
		}
		public void run(){
			try {
				for(int i=0;i<10;i++){
					queue.put("hello"+i);
					System.out.println("put"+i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	static class TakeThread extends Thread{
		private SynchronousQueue queue;
		public TakeThread(SynchronousQueue queue){
			super();
			this.queue=queue;
		}
		public void run(){
			try {
				   for(int i=0;i<10;i++){
					   System.out.println(queue.take());
				   }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]){
		SynchronousQueue que=new SynchronousQueue<String>();
		new TakeThread(que).start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new PutThread(que).start();
		
	}
}
