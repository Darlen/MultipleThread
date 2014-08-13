package demo.pb.threadCommunicateion;
//存款线程
public class DepositThread  implements Runnable{
    /*
     * 模拟用户
     */
    private Account account;
    //用户存钱数
    private double depositAmount;

    public DepositThread(Account account, double depositAmount) {
        super();
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        //重复10次存钱操作
        for(int i=0;i<10;i++){
            account.deposit(depositAmount);
        }

    }

}
