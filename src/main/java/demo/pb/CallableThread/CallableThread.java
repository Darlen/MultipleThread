package demo.pb.CallableThread;

import java.util.concurrent.Callable;
/**
 * <p><tt>Callable</tt>是Runnable接口的增强版，但Callabe是jdk1.5新增的接口，而且它并不是Runnable的子接口。
 * 所以不能直接使用Thread的构造方法{@link Thread(group,target,name,long)}.
 * <p>但是Future接口继承了Runnable接口，并提供了一个FutureTask实现类用来封装Callable对象。
 *
 */
public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i=0;
        for(;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"循环："+i);

        }
        return i;
    }

}
