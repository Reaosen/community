package codingforlove.community.Mapper;

import codingforlove.community.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id, name, token, avatar_url, gmt_modified, gmt_create) " +
            "values (#{accountId}, #{name}, #{token}, #{avatarUrl}, #{gmtModified}, #{gmtCreate}) ")
    public void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}
