package concurrent.repast;

public class ThreadSet extends Thread{

	private RepastService setService;
	public ThreadSet(RepastService setService){
		this.setService=setService;
	}
	public void run(){
		try{
			setService.set();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
