package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
 public static void main(String args[]){
	final Lock lock=new ReentrantLock();
	
	final Condition reachTree=lock.newCondition();
	final Condition reachSix=lock.newCondition();
	Thread threadA = new Thread(new Runnable() {
		@Override
		public void run() {
			//需要先获得锁
			lock.lock();
			try {
				System.out.println("threadA start write");
				//A线程先输出前3个数
				int i=1;
				while (i<= 3) {
					System.out.println(i);
					i++;
				}
				//输出到3时要signal，告诉B线程可以开始了
				reachTree.signal();
			} finally {
				lock.unlock();
			}
			lock.lock();
			try {
				//等待输出6的条件
				reachSix.await();
				System.out.println("threadA start write");
				//输出剩余数字
				int i=6;
				while (i<= 9) {
					System.out.println(i);
					i++;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

	});


	Thread threadB = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				lock.lock();
				reachTree.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			
			try {
				lock.lock();
				//已经收到信号，开始输出4，5，6
				System.out.println("threadB start write");
				int i=4;
				while (i <= 6) {
					System.out.println(i);
					i++;
				}
				//4，5，6输出完毕，告诉A线程6输出完了
				reachSix.signal();
			} finally {
				lock.unlock();
			}
		}

	});


	//启动两个线程
	threadB.start();
	threadA.start();
 }
}
