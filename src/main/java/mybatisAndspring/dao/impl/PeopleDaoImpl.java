package mybatisAndspring.dao.impl;

import mybatisAndspring.dao.PeopleDao;
import mybatisAndspring.model.People;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/28 12:28
 */
public class PeopleDaoImpl extends BaseDaoImpl implements PeopleDao {


    @Override
    public List<People> queryPeople() {
        return sqlSessionTemplate.selectList("mybatisAndspring.dao.queryPeople");
    }
}
