package top.shownmmp.spring.enhance.project.java.base.knowledge.reflect;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-19 19:41
 */
public class User {
    private String userName;
    private Integer userId;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId=" + userId +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public User(String userName, Integer userId, String passWord) {
        this.userName = userName;
        this.userId = userId;
        this.passWord = passWord;
    }

}
