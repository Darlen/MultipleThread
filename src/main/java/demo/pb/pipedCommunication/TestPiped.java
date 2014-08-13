package demo.pb.pipedCommunication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class TestPiped {
    public static void main(String[] args) {
        PipedReader pr = null;
        PipedWriter pw = null;


        try {
            pw = new PipedWriter();
            pr = new PipedReader();
            // 链接管道
            pr.connect(pw);
            new Thread(new ReaderThread(pr),"读取管道线程").start();
            new Thread(new WriterThread(pw),"写入管道线程").start();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
