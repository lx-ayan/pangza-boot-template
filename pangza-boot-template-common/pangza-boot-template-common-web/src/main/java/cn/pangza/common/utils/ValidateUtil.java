package cn.pangza.common.utils;

import org.springframework.validation.BindingResult;

public class ValidateUtil {
    public static ResponseData doValidate(BindingResult bindingResult) {
        if(bindingResult != null && bindingResult.hasErrors()) {
            return ResponseData.paramError(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            return null;
        }
    }
}
