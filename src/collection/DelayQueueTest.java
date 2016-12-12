package collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

	
	static class UserInfo implements Delayed{
        private long delayNanoTime;
        private String userName;
        
        public UserInfo(long delayTime,String userName){
        	super();
        	this.delayNanoTime=delayTime;
        	this.userName=userName;
        }
		public long getDelay(TimeUnit unit) {
			return unit.convert(delayNanoTime-System.nanoTime(), TimeUnit.NANOSECONDS);
		}

		public int compareTo(Delayed o) {
			if(this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS)<0){
				return -1;
			}else if(this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS)>0){
				return 1;
			}
			return 0;
		}
		public long getDelayNanoTime() {
			return delayNanoTime;
		}
		public void setDelayNanoTime(long delayNanoTime) {
			this.delayNanoTime = delayNanoTime;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
	}
	public static void main(String args[]){
		DelayQueue<UserInfo> queue=new DelayQueue<UserInfo>();
		queue.add(new UserInfo(7,"5"));
		queue.add(new UserInfo(6,"4"));
		queue.add(new UserInfo(5,"3"));
		queue.add(new UserInfo(4,"2"));
		queue.add(new UserInfo(3,"1"));
		while(!queue.isEmpty()){
			try {
				System.out.println(queue.take().getUserName()+"---"+System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
