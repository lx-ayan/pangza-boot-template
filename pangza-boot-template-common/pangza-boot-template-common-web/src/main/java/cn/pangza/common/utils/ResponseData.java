package cn.pangza.common.utils;

import cn.pangza.common.enums.ResponseEnum;

public class ResponseData<T> {
    private ResponseEnum code;

    private T data;

    private String message;

    private ResponseData() {};

    public ResponseEnum getCode() {
        return code;
    }

    public void setCode(ResponseEnum code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static<T> ResponseData<T> success() {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_SUCCESS);
        responseData.setData(null);
        responseData.setMessage("操作成功");
        return responseData;
    }

    public static<T> ResponseData<T> success(T data) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_SUCCESS);
        responseData.setData(data);
        responseData.setMessage("操作成功");
        return responseData;
    }

    public static<T> ResponseData<T> success(T data, String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_SUCCESS);
        responseData.setData(data);
        responseData.setMessage(message);
        return responseData;
    }

    public static<T> ResponseData<T> success(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_SUCCESS);
        responseData.setData(null);
        responseData.setMessage(message);
        return responseData;
    }

    public static<T> ResponseData<T> error(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_ERROR);
        responseData.setData(null);
        responseData.setMessage(StringUtil.isEmpty(message)? "操作失败": message);
        return responseData;
    }

    public static <T> ResponseData<T> paramError(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_PARAM_ERROR);
        responseData.setData(null);
        responseData.setMessage(StringUtil.isEmpty(message)? "参数校验失败": message);
        return responseData;
    }

    public static <T> ResponseData<T> tokenError(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_TOKEN_ERROR);
        responseData.setData(null);
        responseData.setMessage(StringUtil.isEmpty(message)? "登录已过期，请重新登录": message);
        return responseData;
    }

    public static <T> ResponseData<T> notFound(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_NOTFOUND);
        responseData.setData(null);
        responseData.setMessage(StringUtil.isEmpty(message)? "登录已过期，请重新登录": message);
        return responseData;
    }

    public static <T> ResponseData<T> gatewayError(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_GATEWAY_ERROR);
        responseData.setData(null);
        responseData.setMessage(StringUtil.isEmpty(message)? "登录已过期，请重新登录": message);
        return responseData;
    }

    public static <T> ResponseData<T> permissionError(String message) {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.setCode(ResponseEnum.RESPONSE_PERMISSION_ERROR);
        responseData.setData(null);
        responseData.setMessage(StringUtil.isEmpty(message)? "权限不足": message);
        return responseData;
    }


}

