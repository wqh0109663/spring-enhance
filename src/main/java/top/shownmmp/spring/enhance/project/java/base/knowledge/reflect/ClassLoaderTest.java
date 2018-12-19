package top.shownmmp.spring.enhance.project.java.base.knowledge.reflect;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-19 20:34
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        /*
         * c++ 写的
         */
        System.out.println(loader.getParent().getParent());
    }
}
