package com.springtest.springaop_11_1;

import com.springtest.profile.People;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 22:51
 */
public class PeopeoImpl implements IPeople {
    @Override
    public void printInfo(People people) {
        System.out.println("id:" + people.getId() + "\nname:" + people.getName() + "\nidentify:" + people.getIdentifyId());
    }
}
