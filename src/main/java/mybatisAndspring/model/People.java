package mybatisAndspring.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 * @date 2020/3/26 18:30
 */

@Data
public class People implements Serializable {

    private int id;
    private String name;
    private String identifyId;
    private double weight;


    @Override
    public String toString() {
        return "[id=" + id + ",name=" + name + ",identifyid=" + identifyId + ",weight=" + weight + "]";
    }

}
