package codingforlove.community.Mapper;

import codingforlove.community.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id, name, token, gmt_modified, gmt_create) " +
            "values (#{accountId}, #{name}, #{token}, #{gmtModified}, #{gmtCreate}) ")
    public void insert(User user);
}
