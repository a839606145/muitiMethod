package collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
 public  static void main(String args[]){
	 Queue queue=new PriorityQueue<Integer>();
	 queue.add(5);
	 queue.add(6);
	 queue.add(4);
	 queue.add(2);
	 queue.add(3);
	 while(!queue.isEmpty()){
		 System.out.println(queue.poll());
	 }
	 System.out.println("-------------");
	 Comparator<Integer> cmp=new Comparator<Integer>(){

		public int compare(Integer o1, Integer o2) {
			return -1*(o1-o2);
		}};

		
		queue=new PriorityQueue<Integer>(5,cmp);
		queue.add(5);
		 queue.add(6);
		 queue.add(4);
		 queue.add(2);
		 queue.add(3);
		 while(!queue.isEmpty()){
			 System.out.println(queue.poll());
		 }
 }
}
