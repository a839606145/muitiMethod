package collection;

import java.util.concurrent.ConcurrentSkipListMap;


public class ConcurrentSkipListMapTest {
	
	static class UserInfo implements Comparable<UserInfo>{
        private int id;
        private String name;
        
        public UserInfo(){
        	super();
        }
        public UserInfo(int id,String name){
        	super();
        	this.id=id;
        	this.name=name;
        }
		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public int compareTo(UserInfo o) {
			if(this.id>o.id){
				return 1;
			}else if(this.id<o.id){
				return -1;
			}
			return 0;
		}
		
	}
	
	
	static class Thread2 extends Thread{
		private ConcurrentSkipListMap<UserInfo,String> map;
		public Thread2(ConcurrentSkipListMap<UserInfo,String> map){
			this.map=map;
		}
		public void run(){
			while(!map.isEmpty()){
				UserInfo u=map.pollLastEntry().getKey();
				System.out.println(u.getId()+"---"+u.getName());
			}
		}
	}
	
	public static void main(String args[]){
		ConcurrentSkipListMap<UserInfo,String> map=new ConcurrentSkipListMap<UserInfo, String>();
		UserInfo u2=new UserInfo(2,"name2");
		UserInfo u1=new UserInfo(1,"name1");
		UserInfo u3=new UserInfo(3,"name3");
		map.put(u2,"hello2");
		map.put(u1,"hello1");
		map.put(u3,"hello3");
		new Thread2(map).start();
		
	}

}
