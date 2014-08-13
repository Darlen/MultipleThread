package demo.pb.pipedCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

/**读取管道中的信息线程*/
public class ReaderThread implements Runnable {
    private PipedReader pr;
    private BufferedReader br;
    public ReaderThread() {
        super();
    }
    public ReaderThread(PipedReader pr) {
        super();
        this.pr = pr;
        //包装管道流
        this.br=new BufferedReader(pr);
    }
    public void run(){

        String buffer=null;
        System.out.println(Thread.currentThread().getName());
        try{
            //开始逐行读取管道流数据（假定管道流数据时字符流）
            System.out.println("------打印管道中的数据-------");
            while((buffer=br.readLine())!=null){
                System.out.println(buffer);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{

            try {
                if(br!=null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
