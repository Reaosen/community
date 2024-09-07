package codingforlove.community.Mapper;

import codingforlove.community.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, creator_id, like_count, comment_count, view_count, tag, gmt_create, gmt_modified) " +
            "values (#{title},#{description},#{creatorId},#{likeCount},#{commentCount},#{viewCount},#{tag},#{gmtCreate},#{gmtModified})")
    public void create(Question question);
}
