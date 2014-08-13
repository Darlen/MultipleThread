package demo.pb.threadGroup;
/**
 * <p>
 * <li>自己的
 * <p>
 *
 * <ul>测试线程组*/
public class TestThread implements Runnable {
//指定线程组

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"线程"+i+"属于"+Thread.currentThread().getThreadGroup().getName()+"线程组");
        }
    }
}
