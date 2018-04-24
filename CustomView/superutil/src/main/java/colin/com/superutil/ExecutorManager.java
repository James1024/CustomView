package colin.com.superutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorManager {
    private ExecutorService executorService;
    private static ExecutorManager threadPool;

    public static ExecutorManager getInstace(){
        if(threadPool==null){
            threadPool=new ExecutorManager();
        }
        return threadPool;
    }

    public ExecutorManager() {
        executorService = Executors.newCachedThreadPool();
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void cancel(){
         executorService.shutdown();
    }

}
