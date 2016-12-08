package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockABC{
	static private int cnt = 0;  
    static Lock lk = new ReentrantLock();  
    public static void main(String[] args) throws InterruptedException {  
        Thread A = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                while(cnt <= 30) {  
                    lk.lock();  
                    if (cnt % 3 == 0) {  
                        System.out.print("A");  
                        cnt++;  
                    }  
                    lk.unlock();  
                }  
            }  
        });  
  
        Thread B = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                while(cnt <= 30) {  
                    lk.lock();  
                    if (cnt % 3 == 1) {  
                        System.out.print("B");  
                        cnt++;  
                    }  
                    lk.unlock();  
                }  
            }  
        });  
  
        Thread C = new Thread(new Runnable() {  
            @Override  
            public void run() {  
                while(cnt <= 30) { 
                	lk.lock();  
                	try{
                		if (cnt % 3 == 2) {  
                			System.out.print("C");  
                			cnt++;  
                		}  
                	}finally{
                		lk.unlock();  
                	}
                }  
            }  
        });  
        A.start();  
        B.start();  
        C.start();  
    }  
}  
