/**
 *VM Args: -Xss50m
 *@author zzm
 */
public class JavaVMStackOOM {
    static int threadCount = 0;

    private void dontStop() {
        while(true) {
            try {
                Thread.currentThread().sleep(5000);    
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }

    public void stackLeakByThread() {
        while(true) {
            threadCount ++;
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        try {
            oom.stackLeakByThread();    
        } catch (OutOfMemoryError ex) {
            System.out.println("ThreadCount:" + threadCount);
            throw ex;
        }
        
    }
}