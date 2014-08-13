package demo.pb.threadCommunicateion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//测试
public class Test {

    public static void main(String []args){
        //创建一个用户没余额，等待先存款后取钱
        Account acct=new Account("123张",0);
        //取款800
        new Thread(new DrawThread(acct,800),"取款者").start();
        //存款2个人
        new Thread(new DepositThread(acct,800),"存款者甲").start();
        new Thread(new DepositThread(acct,800),"存款者乙").start();
        new Thread(new DepositThread(acct,800),"存款者丙").start();

    }
}
