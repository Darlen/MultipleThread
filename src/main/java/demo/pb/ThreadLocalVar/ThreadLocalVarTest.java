package demo.pb.ThreadLocalVar;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程局部变量测试
 * @author Cloudy
 *
 */
class Accout{
    //定义一个ThreadLocal变量，只要调用该类的线程都会保留该变量的一个副本
    private ThreadLocal<String>  threadLocal=new ThreadLocal<String>();
    //初始化threadLocal
    public Accout(String str) {
        this.threadLocal.set(str);
        System.out.println("-------初始化（为ThreadLocal在main中副本）值是："+this.threadLocal.get());
    }
    public String getThreadLocal() {
        return threadLocal.get();
    }
    public void setThreadLocal(String threadLocal) {
        this.threadLocal.set(threadLocal);
    }
}
/**定义一个线程*/
class MyThread implements Runnable{
    //模拟一个AccoutReentrantLock
    private Accout accout;

    public MyThread(Accout accout) {
        super();
        this.accout = accout;
    }
    //线程执行体
    public void run() {
        for(int i=0;i<3;i++){
            if(i==2){
                //设置此线程局部变量的值为当前线程名字
                accout.setThreadLocal(Thread.currentThread().getName());
            }
            System.out.println(i+"------"+Thread.currentThread().getName()+"线程局部变量副本值："+accout.getThreadLocal());
        }
    }

}
public class ThreadLocalVarTest {
    public static void main(String []args){
        ExecutorService pool=Executors.newFixedThreadPool(3);
        //启动三条线程，公用同一个Accout
        Accout ac=new Accout("ThreadLocal本尊");
	/*
	 * 虽然Accout类的只有一个变量所以ThreadLocal类型的变量就导致了同一个Accout对象，
	 * 当i=2后，将会看到3条线程访问同一个ac 而看到不同的ThreadLocal值。
	 */

        pool.submit(new MyThread(ac));
        pool.submit(new MyThread(ac));
        pool.submit(new MyThread(ac));
        pool.shutdown();
    }
}
