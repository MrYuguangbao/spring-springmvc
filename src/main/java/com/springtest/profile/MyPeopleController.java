package com.springtest.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 17:12
 */
@Component
public class MyPeopleController {

    @Autowired
    @Qualifier("peopleServiceImpl")
    public IPeople iPeople;

    public void queryPeople(int id) {
        People people = iPeople.queryPeopleById(id);
        System.out.println(people.getId() + "," + people.getName() + "," + people.getIdentifyId());
    }
}
