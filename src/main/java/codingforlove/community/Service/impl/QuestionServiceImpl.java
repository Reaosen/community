package codingforlove.community.Service.impl;

import codingforlove.community.DTO.QuestionDTO;
import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import codingforlove.community.Mapper.QuestionExtMapper;
import codingforlove.community.Mapper.QuestionMapper;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.Question;
import codingforlove.community.Model.QuestionExample;
import codingforlove.community.Model.User;
import codingforlove.community.Model.UserExample;
import codingforlove.community.Service.QuestionService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PaginationDTO list(Model model, Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();

        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) page = 1;
        if (page > paginationDTO.getTotalPage()) page = paginationDTO.getTotalPage();

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithBLOBsWithRowbounds(new QuestionExample(), new RowBounds(offset, size));

        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountIdEqualTo(question.getCreatorAccountId());
            List<User> users = userMapper.selectByExample(userExample);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(users.get(0));
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    @Override
    public PaginationDTO list(Long id, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                        .andCreatorAccountIdEqualTo(id);
        Integer totalCount = (int) questionMapper.countByExample(example);
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) page = 1;
        if (page > paginationDTO.getTotalPage()) page = paginationDTO.getTotalPage();

        Integer offset = size * (page - 1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorAccountIdEqualTo(id);
        List<Question> questions = questionMapper.selectByExampleWithBLOBsWithRowbounds(new QuestionExample(), new RowBounds(offset, size));

        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (Question question : questions) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountIdEqualTo(question.getCreatorAccountId());
            List<User> users = userMapper.selectByExample(userExample);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(users.get(0));
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);

        return paginationDTO;
    }

    @Override
    public String  getById(Long id, Model model) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(Long.valueOf(question.getCreatorAccountId()));
        List<User> users = userMapper.selectByExample(userExample);
        questionDTO.setUser(users.get(0));
        model.addAttribute("question", questionDTO);
        //阅读数+1
        incView(id);
        return "question";
    }

    @Override
    public void incView(Long id) {
        Question record = new Question();
        record.setId(id);
        record.setViewCount(1);
        questionExtMapper.incView(record);
    }

    @Override
    public String deleteById(Long id) {
        int deleteByPrimaryKey = questionMapper.deleteByPrimaryKey(id);
        if (deleteByPrimaryKey != 1){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        return "redirect:/";
    }
}
