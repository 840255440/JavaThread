package sleep����;

//SleepTest.java��Դ��
//sleep() ������Thread.java�С�
//sleep() ���������õ�ǰ�߳����ߣ�����ǰ�̻߳�ӡ�����״̬�����뵽������(����)״̬����sleep()��ָ������ʱ�䣬
//�߳����ߵ�ʱ������/���ڸ�����ʱ�䣻���߳����±�����ʱ�������ɡ�����״̬����ɡ�����״̬�����Ӷ��ȴ�cpu�ĵ���ִ�С�
class ThreadA extends Thread{
 public ThreadA(String name){ 
     super(name); 
 } 
 public synchronized void run() { 
     try {
         for(int i=0; i <10; i++){ 
             System.out.printf("%s: %d\n", this.getName(), i); 
             // i�ܱ�4����ʱ������100����
             if (i%4 == 0)
                 Thread.sleep(500);
         } 
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 } 
} 

public class SleepTest{ 
 public static void main(String[] args){ 
     ThreadA t1 = new ThreadA("t1"); 
     t1.start(); 
 } 
}
