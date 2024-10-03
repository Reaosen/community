package codingforlove.community.Service.impl;

import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import codingforlove.community.Mapper.QuestionMapper;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.Question;
import codingforlove.community.Model.QuestionExample;
import codingforlove.community.Model.User;
import codingforlove.community.Service.PublishService;
import codingforlove.community.Util.MyStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void doPublish(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("tag") String tag,
                          @RequestParam(value = "id", required = false) Long id,
                          User user) {
        // TODO 前端校验

        //todo 目前tag是一整个字符串，在前端分割。需要新建表，并在后端转换成数组
        Question question = new Question();
        question.setCreatorAccountId(user.getAccountId());
        question.setTitle(title);
        question.setDescription(description);
        question.setProfile(MyStrUtil.taken(description, 256));
        question.setTag(tag);
        question.setId(id);
        question.setViewCount(0L);
        question.setCommentCount(0L);
        question.setLikeCount(0L);

        if (question.getId() == null){
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.insert(question);
        }else {
            question.setGmtModified(System.currentTimeMillis());
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria()
                            .andIdEqualTo(question.getId());
            int updateCode = questionMapper.updateByExampleSelective(question, questionExample);
            if (updateCode != 1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }


    }

    @Override
    public String edit(Long id, Model model) {
        Question question = questionMapper.selectByPrimaryKey(id);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id", question.getId());

        return "publish";
    }
}
