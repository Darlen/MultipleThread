package demo.pb.threadGroup;

public class ThreadGroupTest {
    public static void main(String [] args){
        //获取主线程的线程组
        ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
        System.out.println("主线程的组的名字："+mainGroup.getName());
        System.out.println("主线程组是否属于后台线程组："+mainGroup.isDaemon());
        //新建一个线程组名字为“新线程组”，不设置父线程组
        ThreadGroup tg=new ThreadGroup("私人");
        tg.setDaemon(true);
        System.out.println(tg.getName()+"是否是后台线程组:"+tg.isDaemon());
        Thread th=new Thread(tg,new TestThread(),"线程1");
        System.out.println("1活动的线程有"+tg.activeCount());
        th.start();

        Thread th1=new Thread(tg,new TestThread(),"线程2");
        th1.start();
        System.out.println("2活动的线程有"+tg.activeCount());
        //Thread t1=new Thread();
    }
}
