package codingforlove.community.Mapper;

import codingforlove.community.Model.EmailCode;
import codingforlove.community.Model.EmailCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EmailCodeMapper {
    long countByExample(EmailCodeExample example);

    int deleteByExample(EmailCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailCode record);

    int insertSelective(EmailCode record);

    List<EmailCode> selectByExampleWithRowbounds(EmailCodeExample example, RowBounds rowBounds);

    List<EmailCode> selectByExample(EmailCodeExample example);

    EmailCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailCode record, @Param("example") EmailCodeExample example);

    int updateByExample(@Param("record") EmailCode record, @Param("example") EmailCodeExample example);

    int updateByPrimaryKeySelective(EmailCode record);

    int updateByPrimaryKey(EmailCode record);
}