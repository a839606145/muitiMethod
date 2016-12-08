package thread;

public class RunnableTest implements Runnable {
	private String name;
	private int num=5;
	public RunnableTest(String name){
		this.name=name;
	}
	public RunnableTest(){
		
	}

	public void run() {
		while(num>0){
			System.out.println(Thread.currentThread().getName()+":"+num);
			num--;
			try {
				Thread.sleep((int)Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		/*RunnableTest a=new RunnableTest("A");
		RunnableTest b=new RunnableTest("B");
		new Thread(a).start();//此处需要使用Thread的方法 创建Thread
		new Thread(b).start();*/
		RunnableTest c=new RunnableTest();
		new Thread(c,"C").start();//此处用到了资源共享，因为只是创建了一个RunnableTest实例
		new Thread(c,"D").start();
		new Thread(c,"E").start();
		
		
	}

}
