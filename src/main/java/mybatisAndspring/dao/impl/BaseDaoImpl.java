package mybatisAndspring.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author admin
 * @date 2020/3/28 12:24
 */
public class BaseDaoImpl {

    protected SqlSessionTemplate sqlSessionTemplate = null;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
