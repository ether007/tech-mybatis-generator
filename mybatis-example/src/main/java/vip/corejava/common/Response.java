package vip.corejava.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Response<T> {

    private int code;

    private String message;

    private T body;

    public static Response f() {
        return new Response();
    }

    public static <Body> Response ok(Body body) {
        return f().setCode(200).setMessage("success").setBody(body);
    }

    public static Response notFound() {
        return f().setCode(404).setMessage("not found");
    }
}
