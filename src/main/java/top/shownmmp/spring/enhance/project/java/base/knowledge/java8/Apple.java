package top.shownmmp.spring.enhance.project.java.base.knowledge.java8;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-1-18 下午10:01
 * 苹果实体类
 */
public class Apple {
    private String color;
    private Integer weight;
    /**
     * 第一个版本过滤重的苹果
     *
     * @param apple 为过滤的苹果
     * @return 重的苹果
     */
    public  static  boolean filterHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
