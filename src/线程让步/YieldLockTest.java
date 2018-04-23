package �߳��ò�;
//YieldLockTest.java ��Դ��
//���߳�main�������������߳�t1��t2��t1��t2��run()������ͬһ�������ͬ��������synchronized(obj)��
//��t1���й����У���Ȼ�������Thread.yield()�����ǣ�t2�ǲ����ȡcpuִ��Ȩ�ġ���Ϊ��t1��û���ͷš�obj�����е�ͬ��������
public class YieldLockTest{ 

 private static Object obj = new Object();

 public static void main(String[] args){ 
     ThreadA t1 = new ThreadA("t1"); 
     ThreadA t2 = new ThreadA("t2"); 
     t1.start(); 
     t2.start();
 } 

 static class ThreadA extends Thread{
     public ThreadA(String name){ 
         super(name); 
     } 
     public void run(){ 
         // ��ȡobj�����ͬ����
         synchronized (obj) {
             for(int i=0; i <10; i++){ 
                 System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i); 
                 // i����4ʱ������yield
                 if (i%4 == 0)
                     Thread.yield();
             }
         }
     } 
 } 
}