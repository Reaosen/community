package codingforlove.community.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001, "你找的问题不在了，要不要换一个试试？"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复。"),
    NO_LOGIN(2003, "未登录，请先登录再尝试该操作。"),
    SYS_ERROR(2004, "服务器着火了，我们正在灭火！"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在。"),
    COMMENT_NOT_FOUND(2006, "你找的评论不在了，要不要换一个试试？")

    ;

    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {return code;}

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
