package com.springtest.profile;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 17:11
 */
@Data
@Component
public class People {
    private int id;
    private String name;
    private String identifyId;
    private double weight;
}
