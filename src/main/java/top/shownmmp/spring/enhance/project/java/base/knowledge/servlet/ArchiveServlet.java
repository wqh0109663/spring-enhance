package top.shownmmp.spring.enhance.project.java.base.knowledge.servlet;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-24 10:59
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ArchiveServlet 用来处理个人简历模板页面中传递的数据，简单处理方式
 */
public class ArchiveServlet extends HttpServlet {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1434;DataBaseName=ekp";
    private static final String USER = "sa";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doget");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost........");
        String applicant = request.getParameter("applicant");
        System.out.println(applicant);
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "select * from ekp_167ddb602e1d121145e5 limit 1";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            int count = metaData.getColumnCount();

            List<String> list = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                list.add(metaData.getColumnName(i + 1));
            }
            System.out.println(list);

        } catch (Exception e) {
            throw new RuntimeException("连接或执行sql异常" + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException("关闭rs失败");
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException("关闭statement失败");
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException("关闭conn失败");
                }
            }
        }


    }

}
