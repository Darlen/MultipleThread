package pb.exceptionThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 定义自己的异常类
 */
class MyEx implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t+"线程出现了异常："+e);
    }
}
/**为主线程设置异常处理器,当程序开始运行时抛出未处理的异常，自定义的异常处理器会起作用*/
class MyThread extends Thread{
    public void run(){
        int a=5/0;
    }
}

public class ExHandler {
    public static void main(String []args){

        Thread td=new MyThread();
        //为指定的td线程实例设置异常处理器
        td.setUncaughtExceptionHandler(new MyEx());
        td.start();
        //设置主线程的异常类
        Thread.currentThread().setUncaughtExceptionHandler(new MyEx());
        byte [] b=new byte[2];
        System.out.println(b[2]);
    }
}
