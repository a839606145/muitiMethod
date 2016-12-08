package concurrent.countDown;

public class CountDownServiceThread extends Thread{
   private CountDownService service;
   public CountDownServiceThread(CountDownService service){
	   this.service=service;
   }
   public void run(){
	   try{
		   service.come();
		   service.ready();
		   service.end();
	   }catch (Exception e) {
		   e.printStackTrace();
	}
   }
}
