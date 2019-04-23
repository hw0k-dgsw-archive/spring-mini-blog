package kr.hs.dgsw.spring_mini_blog.protocol;

public enum ResponseType {
    FAIL (0, "Failed to run"),

    USER_GET (100, "User [%s] successfully got"),
    USER_ADD (101, "User [%s] successfully added"),
    USER_UPDATE (102, "User [%s] successfully updated"),
    USER_DELETE (103, "User [%s] successfully deleted"),

    POST_GET (200, "Post [%s] successfully got"),
    POST_ADD (201, "Post [%s] successfully added"),
    POST_UPDATE (202, "Post [%s] successfully updated"),
    POST_DELETE (203, "Post [%s] successfully deleted"),

    ATTACH_STORED (204, "Attach [%s] successfully stored")

    ;

    private final int code;
    private final String desc;

    ResponseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }
}
