package top.shownmmp.spring.enhance.project.java.base.knowledge.xml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
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
        String sql = "select extend_data_xml from km_review_main where " +
                " fd_template_id='150461343fce1f2e6c14a7d4eb2808bd'   ";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        while (resultSet.next()) {
            String str = resultSet.getString(1);
        }


        resultSet.close();
        statement.close();
        if (conn != null) {
            conn.close();
        }


    }


}
