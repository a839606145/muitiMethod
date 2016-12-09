package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String args[]){
		final Vector v=new Vector<String>();
		for(int i=0;i<10;i++){
			v.add("hello"+i);
		}
		
		Vector v2=(Vector) v.clone();
		System.out.println(v2==v); //false
		System.out.println(v2.equals(v)); //true
		System.out.println(v.hashCode()+":"+v2.hashCode()); //相同
		//深复制
		/*Iterator<String> it=v.iterator();
		while(it.hasNext()){
			System.out.println(Thread.currentThread().getName()+":"+it.next());
		}
		v2.set(0, "hhh");
		Iterator<String> it2=v2.iterator();
		while(it2.hasNext()){
			System.out.println(Thread.currentThread().getName()+":"+it2.next());
		}*/
		/*Enumeration<String> e=v.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}*/
		//多线程
		/*new Thread(new Runnable() {
			public void run() {
				Iterator<String> it=v.iterator();
				int i=0;
				while(it.hasNext()){
					i++;
					if(i==4){
						v.remove(i);
					}
					System.out.println(Thread.currentThread().getName()+":"+it.next());
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				Iterator<String> it=v.iterator();
				while(it.hasNext()){
					System.out.println(Thread.currentThread().getName()+":"+it.next());
				}
				
			}
		}).start();
		*/
	}

}
