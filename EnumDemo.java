
public class EnumDemo<T> {
    
    public static void main(String[] args) {
        try {
            System.out.println(Enum.valueOf(Type.class, "Task".toLowerCase()) == Type.task);            
        } catch (IllegalArgumentException ex) {

        }

        System.out.println(Type.task.toString());
    }

    public static enum Type {
        task,
        post,
        work,
        event
    }

    public EnumDemo(T a) {
        print(a);
    }

    public void print(T a) {
        System.out.printf("int: %s\r\n", a.toString());
    }
}