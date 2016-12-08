package thread;
/**
 * 注意每一个线程 都执行了100
 * @author Administrator
 *
 */
public class ThreadTest extends Thread {
	private String name;
	private int num=10;
    public ThreadTest(String name){
    	this.name=name;
    }
	public void run(){
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
		Thread t=new ThreadTest("A");
		Thread t2=new ThreadTest("D");;
		t.start();
		t2.start();//两个一样的不能一起启动
		new Thread(t,"B").start();
		new Thread(t,"c").start();
		
	}

}
