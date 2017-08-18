/**
 *VM Args: -XX:PermSize=10 -XX:MaxPermSize=10 -XX:MaxMetaspaceSize=2k
 *
 */
import java.util.*;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用List保持常量池引用，避免Full GC回收常量池
        List<String> list = new ArrayList<String>();
        // 10MB PermSize 在 integer 范围足够OOM了
        int i = 0;
        while(true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}