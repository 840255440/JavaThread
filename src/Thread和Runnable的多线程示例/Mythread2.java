package Thread��Runnable�Ķ��߳�ʾ��;

public class Mythread2 implements Runnable {
	private int tickets = 5;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			if(this.tickets>0){
			System.out.println(i+Thread.currentThread().getName()+"��������"+tickets--+"��Ʊ");
			}
		}
	}
	public static void main(String[] args) {
		Mythread2 mt=new Mythread2();
		mt.run();
		Thread t1=new Thread(mt);
		Thread t2=new Thread(mt);
		Thread t3=new Thread(mt);
		t1.start();
		t2.start();
		t3.start();
	}
}
