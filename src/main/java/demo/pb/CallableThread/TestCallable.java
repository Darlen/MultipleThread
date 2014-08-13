package demo.pb.CallableThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String []args){
        try {
            CallableThread ct=new CallableThread();
            FutureTask<Integer> target=new FutureTask<Integer>(ct);
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"循环变量："+i);

                if(i==2){
                    new Thread(target,"子线程").start();
                    //boolean isDone（）：如果Callable任务已完成，则返回true，否则返回false
                    System.out.println(target.isDone());
                    Thread.sleep(1);
                }
            }

            //V get():返回Callable任务里call（）的返回值，调用该方法会导致阻塞,必须等到子线程结束时才会得到返回值
            System.out.println("子返回值是："+target.get());
            System.out.println(target.isDone());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
