package thread;
/**
 * 每一个线程 得满足：上一个能获得 自己的能获得 才说明该自己了
 * @author Administrator
 *
 */
public  class calculateWait implements Runnable{
   private String name;
   private Object pre;//锁
   private Object self;//锁
   public calculateWait(String name,Object pre,Object next){
	   this.name=name;
	   this.pre=pre;
	   this.self=next;
   }

	public void run() {
		int count = 10;   
        while (count > 0) {   
            synchronized (pre) {   
                synchronized (self) {   
                    System.out.print(name);   
                    count--;  
                    self.notify();   
                }   
                try {
                	if(count>0){ //注意必须写 否则程序出现了死锁
                		pre.wait();   
                	}
                } catch (InterruptedException e) {   
                    e.printStackTrace();   
                } 
            }
        }
	}
	
	public static void main(String args[]){
		Object oa=new Object();
		Object ob=new Object();
		Object oc=new Object();
		calculateWait a=new calculateWait("A", oc, oa);
		calculateWait b=new calculateWait("B", oa, ob);
		calculateWait c=new calculateWait("C", ob, oc);
		try {
			new Thread(a).start();
			Thread.sleep(100);
			new Thread(b).start();
			Thread.sleep(100); 
			new Thread(c).start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
