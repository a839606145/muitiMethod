package thread;

import java.util.Calendar;
import java.util.Date;

public class ThreadParame implements Runnable{

	private Date date;
	public Date getDate(){
		return date;
	}
	public void run() {
		   Calendar calendar=Calendar.getInstance();   
		   calendar.setTime(new Date()); 
		   System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//今天的日期 
		   calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+1);//让日期加1
		   this.date=calendar.getTime();
	}
	
	public static void main(String args[]){
		ThreadParame p=new ThreadParame();
		Thread ap=new Thread(p);
		ap.start();
		try {
			ap.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(p.getDate());
	}

}
