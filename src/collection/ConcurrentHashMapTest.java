package collection;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	
	public static void main(String args[]){
		ConcurrentHashMap map=new ConcurrentHashMap<String,Integer>();
		new Thread2(map,"A").start();
		new Thread1(map,"A").start();
		try {
			Thread.sleep(2000);
			Iterator<String> keyIt=map.keySet().iterator();
			while(keyIt.hasNext()){
				System.out.println(keyIt.next());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
  
	static class Thread1 extends Thread{
		ConcurrentHashMap map;
		String name;
		public Thread1(ConcurrentHashMap map,String name){
			super();
			this.map=map;
			this.name=name;
		}
		public void run(){
		  for(int i=0;i<100;i++){
			  map.remove(name+i);
			  System.out.println("移除"+name+i);
			  try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		}
	}
	static class Thread2 extends Thread{
		ConcurrentHashMap map;
		String name;
		public Thread2(ConcurrentHashMap map,String name){
			super();
			this.map=map;
			this.name=name;
		}
		public void run(){
		  for(int i=0;i<100;i++){
			  map.put(name+i, i+1);
			  System.out.println(name+i);
			  try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
		}
	}
}
