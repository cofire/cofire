package com.cofire.common.result;

import com.cofire.common.constant.CodeEnum;

/**
 * 
 * @ClassName: Result
 * @Description:返回结果类
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
public class Result {
    private boolean success = false;
    private String code;
    private String message;
    private Long total;
    private Object data;

    public Result() {
        super();
    }

    public Result(boolean success) {
        super();
        this.success = success;
    }

    public Result(CodeEnum codeEnum) {
        super();
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public Result(boolean success, String code) {
        super();
        this.success = success;
        this.code = code;
    }

    public Result(boolean success, CodeEnum codeEnum) {
        super();
        this.success = success;
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public Result(boolean success, String code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public void setSuccess(boolean success, CodeEnum codeEnum) {
        setSuccess(success);
        setCode(codeEnum.getCode());
        setMessage(codeEnum.getMessage());
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
