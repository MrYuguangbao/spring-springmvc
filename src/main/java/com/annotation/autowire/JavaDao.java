package com.annotation.autowire;

import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.autowire
 * @author:admin
 * @createTime 9月 19 2021 18:02:42
 */
@Repository
public class JavaDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "JavaDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
