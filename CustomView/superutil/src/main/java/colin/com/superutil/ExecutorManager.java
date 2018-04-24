package colin.com.superutil;

public class ThreadPool {
    private 
    public static ThreadPool threadPool;

    public static ThreadPool getInstace(){
        if(threadPool==null){
            threadPool=new ThreadPool();
        }
        return threadPool;
    }

    public ThreadPool() {

    }
}
