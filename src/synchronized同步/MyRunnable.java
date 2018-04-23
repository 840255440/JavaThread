package synchronized同步;

public class MyRunnable implements Runnable{
//当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
	//synchronized(this)中的this代表的是MyRunable对象；t1和t2共同一个MyRunable对象，因此，一个线程获取了对象的同步锁，会造成另外一个线程等待。
	int j = 0;
	@Override
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
		Runnable r = new MyRunnable();
		Thread t1 = new Thread(r,"t1");
		Thread t2 = new Thread(r,"t2");
		t1.start();
		t2.start();
	}

}
