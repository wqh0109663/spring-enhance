package top.shownmmp.spring.enhance.project.java.base.knowledge.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

/**
 * 从数据库中解析出包含xml的字段信息，所有 TODO
 *
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-22 11:37
 */
public class MultiRootXmlParserDemo {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1434;DataBaseName=ekp";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;

    public static void main(String[] args) throws Exception {

        Class.forName(DRIVER);
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "select extend_data_xml from szgt_fterp_main where fd_id='1600ab2e240e400b26c0f8e4c66b803a'";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        String str ="";
        while (resultSet.next()) {
            str = resultSet.getString(1);
            System.out.println(str);

        }
        // 将字符串转为XML
        Document doc = DocumentHelper.parseText(str);
        Element rootElt = doc.getRootElement();



        System.out.println("根节点：" + rootElt.getName());
        Iterator iter = rootElt.elementIterator("object");
        while (iter.hasNext()) {
            Element recordEle = (Element) iter.next();
            Iterator iters = recordEle.elementIterator("void");
            while (iters.hasNext()) {
                Element itemEle = (Element) iters.next();
                System.out.println(itemEle);

            }
        }

        resultSet.close();
        statement.close();
        if (conn != null) {
            conn.close();
        }


    }


}
