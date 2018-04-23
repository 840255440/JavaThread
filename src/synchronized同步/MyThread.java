package synchronized同步;

public class MyThread extends Thread{
	//synchronized(this)中的this代表的是MyThread对象，而t1和t2是两个不同的MyThread对象，因此t1和t2在执行synchronized(this)时，获取的是不同对象的同步锁。
	public MyThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	int j=0;
	public void run() {	
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i=0; i<5; i++){
				try {
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName()+" loop "+i+" j="+j++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");
		MyThread t2 = new MyThread("t2");
		t1.start();
		t2.start();
	}
}
