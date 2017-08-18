
public class InstanceOf {
    String abc = null;

    
    public static void main(String[] args) {
        InstanceOf obj = new InstanceOf();
        System.out.printf("Is object's properies is type of String: %b\r\n"
            , obj.abc instanceof String);
        obj.abc = "1111";
        System.out.printf("Now its properies is type of String: %b\r\n"
            , obj.abc instanceof String);
    }
}