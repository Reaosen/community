package codingforlove.community.Enum;

import java.util.Objects;

public enum CommentTypeEnum {

    QUESTION(1),
    COMMENT(2);

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (Objects.equals(commentTypeEnum.getType(), type)) return true;
        }
        return false;
    }
}
