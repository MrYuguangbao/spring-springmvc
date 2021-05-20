package com.springtest.aop.aop1;

import com.springtest.RoleVO;

/**
 * @author admin
 * @date 2019/8/6 18:07
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public void print(RoleVO roleVO) {
        System.out.println("RoleServiceImpl的实现类print方法:" + roleVO.toString());
    }
}
