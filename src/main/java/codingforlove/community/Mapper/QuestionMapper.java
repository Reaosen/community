package codingforlove.community.Mapper;

import codingforlove.community.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, creator_id, like_count, comment_count, view_count, tag, gmt_create, gmt_modified) " +
            "values (#{title},#{description},#{creatorId},#{likeCount},#{commentCount},#{viewCount},#{tag},#{gmtCreate},#{gmtModified})")
    public void create(Question question);

    @Select("select * from question")
    List<Question> find();

    @Select("select * from question limit #{offset}, #{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);


    @Select("select count(1) from question")
    Integer count();
}
