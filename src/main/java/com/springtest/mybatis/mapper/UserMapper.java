package com.springtest.mybatis.mapper;

import com.springtest.mybatis.model.PageParam;
import com.springtest.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface UserMapper {
    /*public User queryUser(int i);*/

    /*public User queryUser(@Param("paramId") int i);*/

    /*public User queryUser(@Param("user") User user, @Param("page")PageParam pageParam);*/
    public List<User> queryUser(@Param("user") User user, RowBounds rowBounds);

    @Delete("delete from people where id=#{id}")
    public int deleteUserById(int id);

    /*public int updateUser(User user);*/

    public List<User> queryUsers(String name);

    public int insertUser(User user);

    //@Select("select * from people where id=#{id}")
    public User queryUserById(int id);

    @SelectProvider(type = UserSqlBuilder.class, method = "builderGetByName")
    public User queryUserBySqlBuilder(String param);

    //@Update("update people set name='测试' where id=#{id}")
    public int updateUser(int id, String name, String identifyId);

    public User queryUserByMap(Map<String, Object> map);

    public List<User> queryByList(List<Integer> idList);//list列表

    public List<User> queryByArray(int[] idArray);//数组

    public List<User> queryBySet(Set<Integer> idSet);//集合

    class UserSqlBuilder {
        public static String builderGetByName(final String param) {
            return new SQL() {{
                SELECT("*");
                FROM("people");
                if (!StringUtils.isEmpty(param)) {
                    WHERE("identify_id = #{param}");
                }
            }}.toString();
        }

    }

    /*@SelectProvider(UserBuilder2.class)
    List<User> queryUser2(String param);

    class UserBuilder2 implements ProviderMethodResolver{
        public static String queryUser2(String param){
            return new SQL(){{
                SELECT("*");
                FROM("people");
                if (!StringUtils.isEmpty(param)) {
                    WHERE("name = #{param}");
                }
            }}.toString();
        }
    }*/
}
