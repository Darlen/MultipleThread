package demo.pb.threadCommunicateion;
//取钱线程
public class DrawThread implements Runnable {
    /*
     * 模拟用户
     */
    private Account account;
    //用户取钱数
    private double drawAmount;

    public DrawThread(Account account, double drawAmount) {
        super();
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        //重复10次取钱操作
        for(int i=0;i<10;i++){
            account.draw(drawAmount);
        }
    }
}
