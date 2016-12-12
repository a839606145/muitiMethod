import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;



public class Test {
 
	public static void main(String args[]){
		Integer[] s=new Integer[2];
		List<String> list=new ArrayList<String>();
		list.add("s");
		s=(Integer[]) list.toArray();
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
		System.out.println(s.getClass());
		/*System.out.println(Object[].class);//[Ljava.lang.Object
		System.out.println(s.getClass()); //[Ljava.lang.String
		System.out.println(new ArrayList<Integer>().getClass());//java.util.ArrayList
*/	}
}
