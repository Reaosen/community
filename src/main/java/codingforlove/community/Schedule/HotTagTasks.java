package codingforlove.community.Schedule;

import cn.hutool.core.util.StrUtil;
import codingforlove.community.Cache.HotTagCache;
import codingforlove.community.Cache.TagCache;
import codingforlove.community.Mapper.QuestionMapper;
import codingforlove.community.Model.Question;
import codingforlove.community.Model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private HotTagCache hotTagCache;

    @Scheduled(fixedRate = 20000)
//    @Scheduled(cron = "0 0 1 * * *")
    public void hotTagSchedule() {
        int offset = 0;
        int limit = 20;
        log.info("hotTagSchedule start: {}", new Date());
        List<Question> list = new ArrayList<>();
        Map<String, Integer> priorities = new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {
                List<String> tags = StrUtil.split(question.getTag(), '，');
                for (String tag : tags) {
                    Integer priority = priorities.get(tag);
                    if (priority != null) {
                        priorities.put(tag, Math.toIntExact(priority + 5 + question.getCommentCount()));
                    } else {
                        priorities.put(tag, Math.toIntExact(5 + question.getCommentCount()));
                    }
                }
            }
            offset += limit;

        }
        hotTagCache.updateTag(priorities);
        log.info("hotTagSchedule stop: {}", new Date());
    }
}
