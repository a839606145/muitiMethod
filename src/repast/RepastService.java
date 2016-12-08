package repast;

import java.util.concurrent.Semaphore;

public class RepastService {
	 volatile private Semaphore setSemaphore=new Semaphore(10);
	 volatile private Semaphore getSemaphore=new Semaphore(8);

}
