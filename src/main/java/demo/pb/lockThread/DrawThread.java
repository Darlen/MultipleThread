package demo.pb.lockThread;

import java.util.concurrent.locks.ReentrantLock;

/**取钱的线程类*/
public class DrawThread implements Runnable{
    //模拟用户账户
    private Accout accout;
    //当前取钱线程所希望取得值
    private double drawAmount;
    private final ReentrantLock relock=new ReentrantLock();
    public DrawThread(Accout accout, double drawAmount) {
        super();
        this.accout = accout;
        this.drawAmount = drawAmount;
    }
    //如果多个线程修改同一个共享数据时，会发生数据安全问题
    public void run() {
        relock.lock();
        try{
            //账户余额大于取款金额时
            if(accout.getBalance()>=drawAmount){
                //取款成功
                System.out.println(Thread.currentThread().getName()+":"+accout.getAccoutName()+"取款成功：吐出钞票："+drawAmount);

                //修改余额
                accout.setBalance(accout.getBalance()-drawAmount);
                System.out.println(Thread.currentThread().getName()+":"+"当前余额为："+accout.getBalance());
            }
            //账户金额不够时
            else{
                System.out.println(Thread.currentThread().getName()+":"+"账户金额不够，您的余额只有"+accout.getBalance());
            }
        }

        finally{
            relock.unlock();
        }
    }

}

	

