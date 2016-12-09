package collection;

import java.util.Stack;

public class StackTest {
  public static void main(String args[]){
	  Stack stack=new Stack();
	  stack.add("hhh");
	  stack.add("kkk");
	  stack.push("lolo");
	  
	  for(int i=0;i<stack.size();i++){
		  System.out.println(stack.pop());
		  i--;
	  }
  }
}
