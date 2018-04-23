package �ػ��߳�;

//Demo.java
class MyThread extends Thread{  
 public MyThread(String name) {
     super(name);
 }

 public void run(){
     try {
         for (int i=0; i<20; i++) {
             Thread.sleep(3);
             System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+ ")" +", loop "+i);
         }
     } catch (InterruptedException e) {
     }
 } 
}; 

class MyDaemon extends Thread{  
 public MyDaemon(String name) {
     super(name);
 }

 public void run(){
     try {
         for (int i=0; i<200; i++) {
             Thread.sleep(1);
             System.out.println(this.getName() +"(isDaemon="+this.isDaemon()+ ")" +", loop "+i);
         }
     } catch (InterruptedException e) {
     }
 } 
}
public class Demo {  
 public static void main(String[] args) {  

     System.out.println(Thread.currentThread().getName()
             +"(isDaemon="+Thread.currentThread().isDaemon()+ ")");

     Thread t1=new MyThread("t1");    // �½�t1
     Thread t2=new MyDaemon("t2");    // �½�t2
     t2.setDaemon(true);                // ����t2Ϊ�ػ��߳�
     t1.start();                        // ����t1
     t2.start();                        // ����t2
 }  
}