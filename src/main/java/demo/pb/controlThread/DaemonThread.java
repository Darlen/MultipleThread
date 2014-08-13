package demo.pb.controlThread;
/**后台进程*/
public class DaemonThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
    public static void main(String [] args){
        //要将前台线程转换成后台线程，需要在该线程刚新建还未start（）之前转换。main线程也是前台线程
        //**********************所有前台线程死亡时，后台线程也就随之死亡。
        DaemonThread dt=new DaemonThread();
        Thread td=new Thread(dt,"线程1");
        System.out.println("main方法是否是后台线程"+Thread.currentThread().isDaemon());
        System.out.println("td线程最初是否是后台线程"+td.isDaemon());
        //**************指定td为后台线程(必须设置在start之前)
        td.setDaemon(true);
        System.out.println("td线程执行setDaemon方法后是否是后台线程"+td.isDaemon());
        //就绪启动后台线程
        td.start();
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

}
