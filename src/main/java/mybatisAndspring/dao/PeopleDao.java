package mybatisAndspring.dao;

import mybatisAndspring.model.People;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/28 12:25
 */
@Repository
public interface PeopleDao {
    List<People> queryPeople();
}
