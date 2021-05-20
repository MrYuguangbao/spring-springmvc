package mybatisAndspring.service;

import mybatisAndspring.model.People;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/28 15:14
 */
public interface PeopleService {
    List<People> queryPeople();
}
