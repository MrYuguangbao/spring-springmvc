package com.springtest.aop.xml;

import com.springtest.RoleVO;
import com.springtest.aop.aop2.AOP验证器;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020/1/7 14:55
 */
public class XmlAspectMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(XmlConfig.class);
        RoleService roleService = context.getBean(RoleService.class);
        AOP验证器 aop = (AOP验证器) roleService;
        RoleVO roleVO = new RoleVO();
        roleVO.setId(1L);
        roleVO.setName("testname");
        roleVO.setNote("testnote");
        if (aop.verify(null)) {
            System.out.println("实体对象为空");
        } else {
            System.out.println("实体对象不为空");
            roleService.print(roleVO);
        }

        context.close();
    }

}
