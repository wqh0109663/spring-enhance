package top.shownmmp.spring.enhance.project.java.base.knowledge.string;

/**
 * 为什么我会创建一个string的类，是用来测试什么，反正不会是关于一些简单的类似于
 * 字符串的拼接啊字符串的子串等等之类的操作
 * 目的是:我想知道的是直接给一个string赋值，string类中的执行过程，也就是初始化过程是怎样的？
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-1-20 下午10:33
 */
public class StringTestDemo {
    public static void main(String[] args) {

        String str = "string";
        System.out.println(str);
        System.out.println(str.length());
    }
}
