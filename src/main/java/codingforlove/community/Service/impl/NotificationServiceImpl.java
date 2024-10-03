package codingforlove.community.Service.impl;

import codingforlove.community.DTO.NotificationDTO;
import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Enum.NotificationStatusEnum;
import codingforlove.community.Enum.NotificationTypeEnum;
import codingforlove.community.Exception.CustomizeErrorCode;
import codingforlove.community.Exception.CustomizeException;
import codingforlove.community.Mapper.CommentMapper;
import codingforlove.community.Mapper.NotificationMapper;
import codingforlove.community.Mapper.QuestionMapper;
import codingforlove.community.Mapper.UserMapper;
import codingforlove.community.Model.*;
import codingforlove.community.Service.NotificationService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(NotificationTypeEnum notificationEnum, Comment comment) {
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notificationEnum.getType());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setOuterid(comment.getParentId());

        notification.setNotifier(comment.getCommentator());
        if (notificationEnum == NotificationTypeEnum.REPLY_COMMENT){
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andAccountIdEqualTo(comment.getCommentator());
            List<User> users = userMapper.selectByExample(example);
            notification.setReceiver(users.get(0).getAccountId());
            notification.setNotifierName(users.get(0).getName());
            notification.setOuterTitle(dbComment.getContent());
        }else {
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            UserExample example = new UserExample();
            example.createCriteria()
                            .andAccountIdEqualTo(question.getCreatorAccountId());
            List<User> users = userMapper.selectByExample(example);
            notification.setReceiver(users.get(0).getAccountId());
            notification.setNotifierName(users.get(0).getName());
            notification.setOuterTitle(question.getTitle());
        }
        notificationMapper.insert(notification);
    }

    @Override
    public PaginationDTO list(Long accountId, Integer page, Integer size) {

        PaginationDTO<NotificationDTO> paginationDTO = new PaginationDTO<>();
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                        .andReceiverEqualTo(accountId);
        Integer totalCount = (int)notificationMapper.countByExample(example);
        paginationDTO.setPagination(totalCount, page, size);

        if (page < 1) page = 1;
        if (page > paginationDTO.getTotalPage()) page = paginationDTO.getTotalPage();

        Integer offset = size * (page - 1);
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria()
                        .andReceiverEqualTo(accountId);
        notificationExample.setOrderByClause("status asc, gmt_create desc");
        List<Notification> notifications = notificationMapper.selectByExampleWithRowbounds(notificationExample, new RowBounds(offset, size));

        if (notifications.size() == 0) return paginationDTO;

        List<NotificationDTO> notificationDTOs = new ArrayList<>();

        for (Notification notification : notifications) {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTO.setTypeName(NotificationTypeEnum.nameOfValue(notification.getType()));
            notificationDTOs.add(notificationDTO);
        }
        paginationDTO.setData(notificationDTOs);
        return paginationDTO;
    }

    @Override
    public Integer unreadCount(Long accountId) {
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                        .andReceiverEqualTo(accountId)
                        .andStatusEqualTo(NotificationStatusEnum.UNREAD.getStatus());
        return (Integer) (int) notificationMapper.countByExample(example);
    }

    @Override
    public Long read(Long id, User user) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if (!Objects.equals(notification.getReceiver(), user.getAccountId())){
            throw new CustomizeException(CustomizeErrorCode.READ_NOTIFICATION_FAIL);
        }
        if (notification.getReceiver() == null){
            throw new CustomizeException(CustomizeErrorCode.NOTIFICATION_NOT_FOUND);
        }
        notification.setStatus(NotificationStatusEnum.READ.getStatus());
        notificationMapper.updateByPrimaryKey(notification);
        if(notification.getType() == NotificationTypeEnum.REPLY_QUESTION.getType()){
            return notification.getOuterid();
        }else {
            Comment comment = commentMapper.selectByPrimaryKey(notification.getOuterid());
            return comment.getParentId();
        }
    }
}
