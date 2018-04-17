package xyz.icloudbadguy.aizaowu.util;

import xyz.icloudbadguy.aizaowu.entity.Result;

public class JsonResult {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        return  success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Throwable e){
        Result result = new Result();
        result.setCode(1);
        result.setMsg(e.getMessage());
        return result;
    }
}
