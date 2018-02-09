package cn.sp.jdk_8;

/**
 * @Author: 2YSP
 * @Description: 菜肴
 * @Date: Created in 2018/2/9
 */
public class Dish {

    /**
     * 名称
     */
    private String name;

    /**
     * 卡路里
     */
    private Integer calories;

    public Dish(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
