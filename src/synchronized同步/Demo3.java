package synchronized同步;

class Count2 {
//
    // 含有synchronized同步块的方法
    public void synMethod() {
        synchronized(this) {
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " synMethod loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }

    // 也包含synchronized同步块的方法
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
        // 新建t1, t1会调用“count对象”的synMethod()方法
        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        count2.synMethod();
                    }
                }, "t1");

        // 新建t2, t2会调用“count对象”的nonSynMethod()方法
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
        t1.start();  // 启动t1
        t2.start();  // 启动t2
        t3.start();
    } 
}
