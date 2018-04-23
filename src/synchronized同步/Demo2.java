package synchronizedͬ��;

class Count {
//��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������߳���Ȼ���Է��ʡ��ö��󡱵ķ�ͬ������顣
    // ����synchronizedͬ����ķ���
    public void synMethod() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // ����100ms
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }

    // ��ͬ���ķ���
    public void nonSynMethod() {
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);  
            }
        } catch (InterruptedException ie) {  
        }
    }
}

public class Demo2 {

    public static void main(String[] args) {  
        final Count count = new Count();
        // �½�t1, t1����á�count���󡱵�synMethod()����
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.synMethod();
                    }
                }, "t1");

        // �½�t2, t2����á�count���󡱵�nonSynMethod()����
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count.nonSynMethod();
                    }
                }, "t2");  


        t1.start();  // ����t1
        t2.start();  // ����t2
    } 
}
