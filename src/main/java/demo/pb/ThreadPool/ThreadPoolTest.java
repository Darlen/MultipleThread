package demo.pb.ThreadPool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestThread implements Runnable{
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

}
public class ThreadPoolTest {
    public static void main(String []args){
//创建一个固定线程数为3的线程池
        ExecutorService pool=Executors.newFixedThreadPool(3);
        //像线程池提交10个线程
        for(int i=0;i<10;i++){
            pool.submit(new TestThread());
            if(i==4){


            }
        }
        //执行完成后关闭线程
        pool.shutdown();
    }
}