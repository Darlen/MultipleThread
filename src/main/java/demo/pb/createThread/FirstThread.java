package demo.pb.createThread;
/**继承Thread来创建线程类*/
public class FirstThread extends Thread {
    private int i;

    //重写run方法，run方法的方法体就是线程执行体
    public void run() {
        for(;i<20;i++){
            System.out.println(this.getName()+":"+i);
        }

    }
    public static void main(String []args){
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"             .."+i);
            if(i==10){
                System.out.println("--------------------------------------------");
                new FirstThread().start();
                new FirstThread().start();
                System.out.println("---------------------------------------------");
            }
        }
    }

}
