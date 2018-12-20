package top.shownmmp.spring.enhance.project.java.base.knowledge.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-19 19:48
 */
public class ReflectTest {
    /**
     * 方法一
     * 使用ClassLoader获取反射的对象
     *
     * @return 反射设置的用户对象
     * @throws Exception 异常
     */
    private static User initByUseClassLoader() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class aClass = classLoader.loadClass("top.shownmmp.spring.enhance.project.java.base.knowledge.reflect.User");
        /*
         * 使用无参构造
         */
        Constructor constructor = aClass.getDeclaredConstructor((Class[]) null);
        /*
         * 带参数构造
         */
        Constructor paramterConstructor = aClass.getDeclaredConstructor(String.class, Integer.class, String.class);
        User wuqihun = (User) paramterConstructor.newInstance("wuqihun", 2, "666");
        System.out.println(wuqihun);

        User instance = (User) constructor.newInstance();
        Method setUserName = aClass.getDeclaredMethod("setUserName", String.class);
        setUserName.invoke(instance, "吴启欢");
        Field passWord = aClass.getDeclaredField("passWord");
        passWord.setAccessible(true);
        passWord.set(instance, "123456");
        Method setUserId = aClass.getDeclaredMethod("setUserId", Integer.class);
        setUserId.invoke(instance, 1);
        return instance;
    }


    /**
     * 直接用ClassForName获得
     *
     * @return User
     * @throws Exception 异常
     */
    private static User initByClassForName() throws Exception {
        Class clazz = Class.forName("top.shownmmp.spring.enhance.project.java.base.knowledge.reflect.User");
        /*
         * 后面是跟上一个差不多的
         */
        return null;
    }

    /**
     * 直接用类名点class获得
     *
     * @return User
     * @throws Exception 异常
     */
    private static User initByUserClass() throws Exception {
        Class clazz = User.class;
        /*
         * 后面是跟上一个差不多的
         */
        return null;
    }

    /**
     * 直接obj类getclass方法获得
     *
     * @return User
     * @throws Exception 异常
     */
    private static User initByObjectGetClass() throws Exception {
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        /*
         * 后面是跟上一个差不多的
         */
        return null;
    }


    public static void main(String[] args) throws Exception {
        User user = initByUseClassLoader();
        System.out.println(user.toString());

    }


}
