/**
 * JDK 1.6 intern() 将第一次遇到的字符串复制到永久代中，并返回引用
 * 而StringBuilder创建的实例是在Java堆上，所以不是一个引用
 *
 * JDK 1.7 开始不会再复制实例，而是在常量池里记录首次出现的实例引用
 * 因此返回的引用是同一个。
 * “java”这个字符串在StringBuilder创建前就已经存在，所以返回的引用与
 * StringBuilder构建出来的不相同
 */

public class StringIntern {
    
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("科学").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); 
    }

}