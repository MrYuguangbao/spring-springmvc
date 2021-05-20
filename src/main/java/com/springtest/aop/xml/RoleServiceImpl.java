package com.springtest.aop.xml;

import com.springtest.RoleVO;

/**
 * @author admin
 * @date 2020/1/7 14:43
 */
public class RoleServiceImpl implements RoleService {


    @Override
    public void print(RoleVO roleVO) {
        System.out.println("连接点方法：" + roleVO.toString());
    }
}
