package com.springtest.springel;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 20:04
 */
@Component("elbean")
@Data
public class ELBean {

    @Value("#{elvo}")
    private ELVO elvo;

    @Value("#{elvo.id}")
    private int id;

    @Value("#{elvo.getName()?.toString()}")
    private String name;

    @Value("#{T(Math).PI}")
    private double pi;

    @Value("#{T(Math).random()}")
    private double random;

    @Value("#{elvo.id+12}")
    private int myNum;

    @Value("#{elvo.name+elvo.id.toString()}")
    private String myString;

    @Value("#{elvo.id==1}")
    private boolean idEqual;

    @Value("#{elvo.id eq 1}")
    private boolean idEqual1;

    @Value("#{elvo.name eq 'jordan'}")
    private boolean idEqual2;

    @Value("#{elvo.name == 'jordan'}")
    private boolean idEqual3;

    @Value("#{elvo.id > 3}")
    private boolean idEqual4;

    @Value("#{elvo.id < 3}")
    private boolean idEqual5;

    @Value("#{elvo.id>5?12:5}")
    private int testId;

    @Value("#{elvo.name == null?'buweikong':'weikong'}")
    private String defa;

}
