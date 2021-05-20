package com.springtest.springel;

import com.springtest.profile.People;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 19:49
 */
public class SpringELExam {

    public static void main(String[] args) {
        /*ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello world'");
        String value = (String)expression.getValue();
        System.out.println("str:"+value);

        expression = parser.parseExpression("new String('hello')");
        String c = (String)expression.getValue();
        System.out.println("c:"+c);

        ELVO elvo = new ELVO(1,"dd");
        expression = parser.parseExpression("name");
        System.out.println("name:"+expression.getValue());*/

        ApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELBean bean = context.getBean(ELBean.class);
        System.out.println(bean.getId() + "\n" + bean.getName()
                + "\n" + bean.getPi() + "\n" + bean.getRandom()
                + "\n" + bean.getMyNum() + "\n" + bean.getMyString()
                + "\n" + bean.isIdEqual() + "\n" + bean.isIdEqual1()
                + "\n" + bean.isIdEqual2() + "\n" + bean.isIdEqual3()
                + "\n" + bean.isIdEqual4() + "\n" + bean.isIdEqual5()
                + "\n" + bean.getTestId() + "\n" + bean.getDefa());


    }

}
