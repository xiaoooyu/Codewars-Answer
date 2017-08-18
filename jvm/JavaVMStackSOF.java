/**
 * VM Args: -Xss160k
 * @author zzm
 */

public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + sof.stackLength);
            throw e;
        }
    }
}