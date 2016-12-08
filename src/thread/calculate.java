package thread;

import java.util.Calendar;
import java.util.Date;

/**
 * 线程是操作完一个对象就要回写到主内存的 因此 原先我想同步减了num，然后就释放对象，输出时是有问题的，
 *         因为输出时又要访问主存中的对象而不是自己刚才得到的对象
 * 思路：将输出也放在同步中  
 *      用局部变量保存临时值，输出使用局部变量，因为局部变量的操作自由自己
 * JVM会在所有的非守护线程（用户线程）执行完毕后退出；
 * main线程是用户线程；
 * 仅有main线程一个用户线程执行完毕，不能决定JVM是否退出，也即是说main线程并不一定是最后一个退出的线程。
 * @author Administrator
 *
 */
public class calculate extends Thread {
	private int num=100;
	
	public void run(){
		while(true){
			   int own=-1; //方法内的变量 用来临时保存从对象中得到的数
				synchronized(calculate.class){
					num--;
					own=num;
				}
				if(own+1>0){
					System.out.println(Thread.currentThread().getName()+":"+(own+1));
				}else{
					break; 
				}
				/*synchronized(calculate.class){
					num--;
					if(num+1>0){
						System.out.println(Thread.currentThread().getName()+":"+(num+1));
					}else{
						break; 
					}
				}*/
			   try {
				   Thread.sleep((int)Math.random() * 10);
			   } catch (InterruptedException e) {
				   e.printStackTrace();
			   }
		}
	}
	public static void main(String args[]){
		Date start=new Date();
		Thread t=new calculate();
			Thread A=new Thread(t,"B");
			A.start();
			Thread B=new Thread(t,"c");
			B.start();
		/*while(A.isAlive() && B.isAlive()){
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
			try {
				A.join();
				B.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(new Date().getTime()-start.getTime());
		
	}

}
