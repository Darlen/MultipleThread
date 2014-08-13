package demo.pb.createThread;

public class SecondThread implements Runnable {


    private int i = 0;
    public void run() {
        for(;i<20;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
    public static void main(String [] args){
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"             .."+i);
            if(i==10){
                SecondThread st=new SecondThread();
                //通过new Thread（ Runable target,String name）来创建新线程
                System.out.println("--------------------------------------------");
                new Thread(st).start();
                new Thread(st).start();
                System.out.println("--------------------------------------------");

            }

        }
    }

}
