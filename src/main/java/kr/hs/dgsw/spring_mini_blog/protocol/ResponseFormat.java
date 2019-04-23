package kr.hs.dgsw.spring_mini_blog.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFormat {
    private int code;
    private String desc;
    private Object data;

    public ResponseFormat(ResponseType type, Object data, Object option) {
        this.code = type.code();
        this.desc = option instanceof Long || option instanceof String
                ? String.format(type.desc(), option)
                : type.desc();
        this.data = data;
    }

    public ResponseFormat(ResponseType type, Object data) {
        this(type, data, null);
    }
}
