package �ȴ��뻽��;

//WaitTimeoutTest.java��Դ��
class Threa extends Thread{

 public Threa(String name) {
     super(name);
 }

 public void run() {
     System.out.println(Thread.currentThread().getName() + " run ");
     // ��ѭ�����������С�
     while(true)
         ;
 }
}

public class WaitTimeoutTest {

 public static void main(String[] args) {

     Threa t1 = new Threa("t1");

     synchronized(t1) {
         try {
             // �������߳�t1��
             System.out.println(Thread.currentThread().getName() + " start t1");
             t1.start();

             // ���̵߳ȴ�t1ͨ��notify()���� �� notifyAll()���ѣ��򳬹�3000ms��ʱ��Ȼ��ű����ѡ�
             System.out.println(Thread.currentThread().getName() + " call wait ");
             t1.wait(3000);

             System.out.println(Thread.currentThread().getName() + " continue");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }
}
