package top.shownmmp.spring.enhance.project.java.base.knowledge.set;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2019-01-03 18:53
 */
public class SetTestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("222");
        list.add("111");
        System.out.println(list);
        StringBuilder sb= new StringBuilder();
        for (int i = 0 ; i < list.size();i++){
            if(i==list.size()-1){
                sb.append("'").append(list.get(i)).append("'");
            }else {
                sb.append("'").append(list.get(i)).append("',");
            }
        }
        System.out.println(sb);
    }

}
