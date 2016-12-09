package concurrent.repast;

public class ThreadGet extends Thread{
	private RepastService getService;
	public ThreadGet(RepastService getService){
		this.getService=getService;
	}
	public void run(){
		try{
			getService.get();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
