package demo.pb.controlThread;
/**
 * 测试：让一个线程等待另一个线程完成的方法：join（）。当在某个程序执行流中调用其他线程的join（）方法，那该执行流对应的线程
 *      就会阻塞，知道被join（）加入的join线程完成为止。
 *      join方法通常有使用线程的程序调用，将大问题划分成许多小问题，每个小问题分配一个线程。当所有的小问题都得到处理后，再调用
 *      主线程来进一步操作
 * @author Cloudy
 *
 */
public class JoinThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
    public static void main(String [] args) throws InterruptedException{
        //实例化一个Runnable
        JoinThread jt=new JoinThread();
        //创建一个线程
        new Thread(jt,"join").start();
        for(int i=0;i<10;i++){
            if(i==3){
                Thread th=new Thread(jt,"joinson");
                //启动第二个线程
                th.start();
                //main的线程中调用了th线程的join方法
                //让第二个线程执行完成后再执行main
                th.join();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }


    }


}
