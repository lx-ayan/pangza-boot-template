package cn.pangza.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseEnum {

    RESPONSE_SUCCESS(200),
    RESPONSE_ERROR(500),
    RESPONSE_NOTFOUND(404),
    RESPONSE_PARAM_ERROR(400),
    RESPONSE_GATEWAY_ERROR(502),
    RESPONSE_TOKEN_ERROR(401),
    RESPONSE_PERMISSION_ERROR(403);

    @JsonValue
    Integer code;

    ResponseEnum(Integer code) {
        this.code = code;
    }
}
