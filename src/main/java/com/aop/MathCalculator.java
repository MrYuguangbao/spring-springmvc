package com.aop;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.springtest.aop
 * @author:admin
 * @createTime 9月 20 2021 17:59:07
 */
public class MathCalculator {

    public double div(int i, int j) {
        System.out.println("执行业务逻辑方法MathCalculator#div");
        return i / j;
    }
}
