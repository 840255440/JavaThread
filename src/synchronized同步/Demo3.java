package synchronizedͬ��;

class Count2 {
//
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

    // Ҳ����synchronizedͬ����ķ���
    public void nonSynMethod() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }
    }
    
    public static synchronized void SynMethod2() {
        try {  
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " nonSynMethod loop " + i);  
            }
        } catch (InterruptedException ie) {  
        }
    }
}

public class Demo3 {

    public static void main(String[] args) {  
        final Count2 count2 = new Count2();
        // �½�t1, t1����á�count���󡱵�synMethod()����
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count2.synMethod();
                    }
                }, "t1");

        // �½�t2, t2����á�count���󡱵�nonSynMethod()����
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count2.nonSynMethod();
                    }
                }, "t2");  

        Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Count2.SynMethod2();
			}
		},"t3");
        t1.start();  // ����t1
        t2.start();  // ����t2
        t3.start();
    } 
}
