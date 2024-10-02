package codingforlove.community.Service;

import codingforlove.community.DTO.PaginationDTO;
import codingforlove.community.Enum.NotificationTypeEnum;
import codingforlove.community.Model.Comment;
import codingforlove.community.Model.User;

public interface NotificationService {
    void insert(NotificationTypeEnum notificationEnum, Comment comment);

    PaginationDTO list(Long accountId, Integer page, Integer size);

    Integer unreadCount(Long accountId);

    Long read(Long id, User user);
}
