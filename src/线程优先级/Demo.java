package �߳����ȼ�;

class MyThread extends Thread{  
    public MyThread(String name) {
        super(name);
    }

    public void run(){
        for (int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName()
                    +"("+Thread.currentThread().getPriority()+ ")"
                    +", loop "+i);
        }
    } 
}; 

public class Demo {  
    public static void main(String[] args) {  

        System.out.println(Thread.currentThread().getName()
                +"("+Thread.currentThread().getPriority()+ ")");

        Thread t1=new MyThread("t1");    // �½�t1
        Thread t2=new MyThread("t2");    // �½�t2
        t1.setPriority(1);                // ����t1�����ȼ�Ϊ1
        t2.setPriority(10);                // ����t2�����ȼ�Ϊ10
        t1.start();                        // ����t1
        t2.start();                        // ����t2
    }  
}