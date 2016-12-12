package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
 public static void main(String args[]){
	 Set set=new LinkedHashSet<String>();//有序
	// Set set=new HashSet<String>();//有序
	 set.add("b");
	 set.add("c");
	 set.add("a");
	 set.add("a");
	 set.add("d");
	 set.add("e");
	 Iterator it=set.iterator();
	 while(it.hasNext()){
		 System.out.println(it.next());
	 }
 }
}
