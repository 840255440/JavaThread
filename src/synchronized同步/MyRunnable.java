package synchronizedͬ��;

public class MyRunnable implements Runnable{
//��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������̶߳ԡ��ö��󡱵ĸá�synchronized���������ߡ�synchronized����顱�ķ��ʽ���������
	//synchronized(this)�е�this�������MyRunable����t1��t2��ͬһ��MyRunable������ˣ�һ���̻߳�ȡ�˶����ͬ���������������һ���̵߳ȴ���
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
