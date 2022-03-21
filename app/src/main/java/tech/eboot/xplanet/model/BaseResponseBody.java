package tech.eboot.xplanet.model;

/**
 * @auther Planck
 * @date 2022/2/18
 * @time 16:19.
 */
public class BaseResponseBody<T> {

    private String code;//状态码
    private String msg;//消息
    private T token;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getToken() {
        return token;
    }

    public void setToken(T token) {
        this.token = token;
    }

    public boolean isOk() {
        return code.equals("200");
    }

}
