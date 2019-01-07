package top.shownmmp.spring.enhance.project.java.base.knowledge.dateformate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2019-01-04 9:10
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-04");
        /*
        * Fri Jan 04 00:00:00 CST 2019
        * */
        System.out.println(parse);
        LocalDate parse1 = LocalDate.parse("2019-01-04");
        System.out.println(parse1);

    }
}
