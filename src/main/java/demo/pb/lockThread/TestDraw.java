package demo.pb.lockThread;

public class TestDraw {
    public static void main(String[]args) throws InterruptedException{
        //创建一个用户
        Accout acct=new Accout("123456", "小明", 1000);
        //模拟四个线程同时操作
        DrawThread dt=new DrawThread(acct,600);
        //DrawThread dt1=new DrawThread(acct,800);
        Thread th1=new Thread(dt,"线程1");
        Thread th2=new Thread(dt,"线程2");
        Thread th3=new Thread(dt,"线程3");
        Thread th4=new Thread(dt,"线程4");
        th4.join();
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
