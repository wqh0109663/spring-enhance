package top.shownmmp.spring.enhance.project.java.base.knowledge.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-1-18 下午9:58
 * 自己给自己来点需求：
 * 算了还是用文章中使用的例子，自己写实现
 * 关于农民朋友筛选苹果的例子
 */
public class LambdaDemo1 {
    /**
     * 第一个版本过滤重的苹果
     *
     * @param list 为过滤的苹果
     * @return 重的苹果
     */
    private static List<Apple> filterHeavyApple(List<Apple> list) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                list) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 第二个版本过滤出红的苹果
     *
     * @param list 为过滤的苹果
     * @return 红的苹果
     */
    private static List<Apple> filterRedApple(List<Apple> list) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                list) {
            if ("红色".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        /*
         * 模拟数据
         *
         */
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("红色", 270));
        apples.add(new Apple("青色", 90));
        apples.add(new Apple("青色", 170));
        apples.add(new Apple("红色", 70));
        apples.add(new Apple("红色", 80));
        apples.add(new Apple("红色", 79));
        /* 过滤重的苹果 */
        List<Apple> apples1 = filterHeavyApple(apples);

        System.out.println(apples);
        System.out.println(apples1);

        /* 过滤红的苹果 */
        List<Apple> apples2 = filterRedApple(apples);
        System.out.println(apples);
        System.out.println(apples2);

        /* 第三个版本过滤出红的重的苹果*/
        List<Apple> apples3 = filterRedApple(filterHeavyApple(apples));
        System.out.println(apples);
        System.out.println(apples3);
        /*
         * Lambda 表达式应该算简易版的实现接口的匿名内部类
         */
        /*重构后的第一个版本 筛选出重的苹果*/
        List<Apple> apples4 = filterAppleByPredicate(apples, (apple) -> apple.getWeight() > 150);
        System.out.println(apples);
        System.out.println(apples4);
        /* 重构第一个版本重的红的苹果 */
        List<Apple> apples5 = filterAppleByPredicate(apples, (apple) -> apple.getWeight() > 150 && "红色".equals(apple.getColor()));
        System.out.println(apples);
        System.out.println(apples5);
        /*使用方法引用 */
        List<Apple> apples6 = filterAppleByPredicate(apples, Apple::filterHeavyApple);
        System.out.println(apples);
        System.out.println(apples6);
        /*
         * 方法引用有三种
         * 1 指向静态的方法引用
         * 2 指向任意实例方法的引用
         * 3 指向现有实例对象的方法引用
         */
    }

    private static List<Apple> filterAppleByPredicate(List<Apple> list, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                list) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;

    }
}



