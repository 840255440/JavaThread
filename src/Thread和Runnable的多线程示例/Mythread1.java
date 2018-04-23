package Thread和Runnable的多线程示例;

class Mythread1 extends Thread{
	private int tickets = 5;
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(i+this.getName()+"正在卖第"+tickets--+"张票");
		}
	}
	
	public static void main(String[] args) {
		Mythread1 my1 = new Mythread1();
		Mythread1 my2 = new Mythread1();
		Mythread1 my3 = new Mythread1();
		
		my1.start();
		my2.start();
		my3.start();
	}
}