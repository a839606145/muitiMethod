package multiThread.repast;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RepastService {
	volatile private Semaphore setSemaphore=new Semaphore(10);
	volatile private Semaphore getSemaphore=new Semaphore(20);
	volatile private ReentrantLock lock=new ReentrantLock();
	volatile private Condition setCondition=lock.newCondition();
	volatile private Condition getCondition=lock.newCondition();
	volatile private Object[] productPosition=new Object[4];
	private boolean isEmpty(){
		boolean isEmpty=true;
		for(int i=0;i<productPosition.length;i++){
			if(productPosition[i]!=null){
				isEmpty=false;
				break;
			}
		}
		if(isEmpty==true){
			return true;
		}else{
			return false;
		}
	}
		
	private boolean isFull(){
			boolean isFull=true;
			for(int i=0;i<productPosition.length;i++){
				if(productPosition[i]==null){
					isFull=false;
					break;
				}
			}
			return isFull;
	}
	
	public void set(){
		try{
			setSemaphore.acquire();
			lock.lock();
			while(isFull()){
				setCondition.await();
			}
			for(int i=0;i<productPosition.length;i++){
				if(productPosition[i]==null){
					productPosition[i]="数据";
					System.out.println(Thread.currentThread().getName()+"生产了"+i);
					break;
				}
			}
			getCondition.signalAll();
			lock.unlock();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			setSemaphore.release();
		}
		
	}
	public void get(){
		try{
			getSemaphore.acquire();
			lock.lock();
			while(isEmpty()){
				getCondition.await();
			}
			for(int i=0;i<productPosition.length;i++){
				if(productPosition[i]!=null){
					productPosition[i]=null;
					System.out.println(Thread.currentThread().getName()+"消耗了"+i);
					break;
				}
			}
			setCondition.signalAll();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
			getSemaphore.release();
		}
		
	}

}
