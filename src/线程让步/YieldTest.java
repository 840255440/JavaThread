package œﬂ≥Ã»√≤Ω;

public class YieldTest {
	public static void main(String[] args) {
		Thread t1 = new ThreadA("t1");
		Thread t2 = new ThreadA("t2");
		t1.start();
		t2.start();
	}
}

class ThreadA extends Thread{
	public ThreadA(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public synchronized void run(){
		for(int i=0; i<10; i++){
			System.out.printf("%s,[%d]:%d\n",this.getName(),this.getPriority(),i);
			if(i%4==0){
				Thread.yield();
			}
		}
	}
}