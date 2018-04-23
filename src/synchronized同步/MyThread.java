package synchronizedͬ��;

public class MyThread extends Thread{
	//synchronized(this)�е�this�������MyThread���󣬶�t1��t2��������ͬ��MyThread�������t1��t2��ִ��synchronized(this)ʱ����ȡ���ǲ�ͬ�����ͬ������
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
