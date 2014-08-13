package demo.pb.threadCommunicateion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 账户类，用面向对象的DDD设计模式来设计 */
/*
 * DDD领域驱动模式，即将每个类都认为是一个完备的领域对象， 例如Account代表账户类，那么就应该提供用户账户的相关方法（存，取，转），而不是将
 * setXXX方法暴露出来任人操作。 只要设计到DDD就需要重写equals和hashcode来判断对象的一致性
 */
public class Account {
    // 账户编码
    private String accountNo;
    // 账户余额
    private double balance;
    // 标示账户是否已有存款(此项目为了测试存入款就需要马上取出)
    private boolean flag = false;
    //	private final Lock lock=new ReentrantLock();
//	private final Condition cond=lock.newCondition();
    public Account() {
        super();
    }

    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // 取款(利用同步方法)
    public synchronized void draw(double drawAmount) {
        // 如果flag为假,没人存款进去，取钱方法（利用wait）阻塞（wait阻塞时，当前线程会释放同步监视器）
        try {
            if (!flag) {
                this.wait();//条件 cond.await();
            }
            //否则执行取钱
            else
            {  // System.out.println("账户余额："+balance);
                System.out.println(Thread.currentThread().getName()+":"+"---->取钱："+drawAmount);
                balance -= drawAmount;
                System.out.println(Thread.currentThread().getName()+":"+"账户余额: "+balance);
                //设置flag（限定一个操作只能取一次钱）
                flag=false;
                //唤醒其他wait（）线程
                this.notifyAll();//cond.signalAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    //存款
    public synchronized void deposit(double depositAmount){
        //如果flag为真，证明有人存钱了，存钱阻塞
        try {
            if (flag) {
                this.wait(); //cond.await();
            }
            //否则执行存款
            else
            {  // System.out.println("账户余额："+balance);
                System.out.println(Thread.currentThread().getName()+":"+"---->存钱："+depositAmount);
                balance+=depositAmount;
                System.out.println(Thread.currentThread().getName()+":"+"账户余额: "+balance);
                //设置flag（限定一个操作只能取一次钱）
                flag=true;
                //唤醒其他wait（）线程
                this.notifyAll(); //cond.signalAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // DDD设计模式重写equals和hashcode(判断用户是否一致，只需要判断他们的账号编码就可以了，不需要再判断整个对象，提高性能)
    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == Account.class) {
            Account account = (Account) obj;
            return account.getAccountNo().equals(accountNo);
        }
        return false;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
