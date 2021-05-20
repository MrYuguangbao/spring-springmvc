package mybatisAndspring.service.impl;

import mybatisAndspring.dao.PeopleDao;
import mybatisAndspring.model.People;
import mybatisAndspring.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/28 15:14
 */

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED ,propagation = Propagation.SUPPORTS)
    public List<People> queryPeople() {
        return peopleDao.queryPeople();
    }
}
