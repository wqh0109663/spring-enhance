package top.shownmmp.spring.enhance.project.java.base.knowledge.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 跟大多数sub操作一样，sub只包含开头，不包含后面的，就是前闭后开的那种
 * 我们知道list有sublist方法，但是只有两个参数的那种，就是fromIndex到toIndex的那一个
 * 1. 问题就是如果我想取到sub的最后一个元素，我应该怎么做
 * 2. 为什么sublist没有只有一个参数的方法，像string的substring一样，可以只指定开头
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-1-20 下午11:00
 */
public class SubListTestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        List<String> strings = list.subList(1, 3);
        System.out.println(strings);


    }
}
