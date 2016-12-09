package concurrent.repast;

public class MainTest {
 public static void main(String args[]) throws Exception{
	 RepastService service=new RepastService();
	 ThreadGet[] g=new ThreadGet[30];
	 ThreadSet[] s=new ThreadSet[30];
	 for(int i=0;i<30;i++){
		 g[i]=new ThreadGet(service);
		 s[i]=new ThreadSet(service);
	 }
	 Thread.sleep(200);
	 for(int i=0;i<30;i++){
		 s[i].start();
		 g[i].start();
	 }
 }
}
