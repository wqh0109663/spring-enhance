package top.shownmmp.spring.enhance.project.java.base.knowledge.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用list的sublist实现分页
 *
 * @author 吴启欢
 * @version 1.0
 * @date 19-1-6 下午1:49
 */
public class SubListTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i < 5) {
                list.add("aaa");
            } else if (i < 10) {
                list.add("bbb");
            } else if (i < 15) {
                list.add("ccc");
            } else {
                list.add("ddd");
            }
        }
        /*
         * 用来模拟数据
         */
        System.out.println(list);
        /*
         * 这一页需要的数量
         */
        int pageSize = 21;
        if (pageSize >= list.size()) {
            /*
             *如果请求的一页总数大于list中的条目数,返回全部的list中的条目
             */
            System.out.println("请求的一页总数大于list中的条目数,返回全部的list中的条目:" + list);
            return;
        } else {

            /*
             *总共几页
             */
            int pageCount;
            int m = list.size() % pageSize;
            System.out.println("余数：" + m);
            if (m > 0) {
                pageCount = list.size() / pageSize + 1;
            } else {
                pageCount = list.size() / pageSize;
            }
            System.out.println("pageCount:" + pageCount);
            /*
             * 第几页
             */
            int page = 3;
            if (page > pageCount) {

                System.out.println(new ArrayList<String>());
                return;
            }

            int formIndex = (page - 1) * pageSize;

            int toIndex = formIndex + pageSize;
            if (page == pageCount) {
                toIndex = list.size();
            }
            System.out.println("formIndex:" + formIndex + ",toIndex:" + toIndex);
            List<String> subList = list.subList(formIndex, toIndex);
            System.out.println(subList);
        }
    }


}
