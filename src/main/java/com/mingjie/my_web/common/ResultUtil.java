package com.mingjie.my_web.common;

public class ResultUtil {

    public static BaseResult success(Object data){
        return ReturnResult(ResultEnum.SUCCESS.getMsg(),data);
    }
    public static BaseResult error(Object data){
        return ReturnResult(ResultEnum.ERROR.getMsg(),data);
    }

    /**
     * 封装返回结果
     * @param msg
     * @param data
     * @return
     */
    public static BaseResult ReturnResult(String msg,Object data){
        BaseResult result = new BaseResult();
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

}

