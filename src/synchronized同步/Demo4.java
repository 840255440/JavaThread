package synchronizedͬ��;

//synchronized�������Ը���ȷ�Ŀ��Ƴ�ͻ���Ʒ���������ʱ����ָ���Ч�ʡ�����ͨ��һ��ʾ������ʾ��
public class Demo4 {

 public synchronized void synMethod() {
     for(int i=0; i<20000000; i++)
         ;
 }

 public void synBlock() {
     synchronized( this ) {
         for(int i=0; i<20000000; i++)
             ;
     }
 }

 public static void main(String[] args) {
     Demo4 demo = new Demo4();

     long start, diff;
     start = System.currentTimeMillis();                // ��ȡ��ǰʱ��(millis)
     demo.synMethod();                                // ���á�synchronized������
     diff = System.currentTimeMillis() - start;        // ��ȡ��ʱ���ֵ��
     System.out.println("synMethod() : "+ diff);
     
     start = System.currentTimeMillis();                // ��ȡ��ǰʱ��(millis)
     demo.synBlock();                                // ���á�synchronized�����顱
     diff = System.currentTimeMillis() - start;        // ��ȡ��ʱ���ֵ��
     System.out.println("synBlock()  : "+ diff);
 }
}