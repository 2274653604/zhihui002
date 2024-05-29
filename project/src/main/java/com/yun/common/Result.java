package com.yun.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_AUTH_ERROR = 401;
    public static final Integer CODE_SYS_ERROR = 500;

    private int code; // 编码 200/400
    private String msg; // 成功/失败
    private Long total; // 总记录数
    private Object data; // 数据

    public static Result fail() {
        return result(400, "失败", 0L, null);
    }

    public static Result fail(String msg) {
        return result(400, msg, 0L, null);
    }

    public static Result suc(Object data) {
        return result(200, "成功", 0L, data);
    }

    public static Result suc(List<Integer> ids) {
        return result(200, "成功", 0L, ids);
    }

    public static Result suc(Object data, Long total) {
        return result(200, "成功", total, data);
    }


    public static Result success(Object data) {
        return new Result(CODE_SUCCESS, "请求成功", 0L, data);
    }

    public static Result error(String msg) {
        return new Result(CODE_SYS_ERROR, msg, 0L, null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg, 0L, null);
    }

    private static Result result(int code, String msg, Long total, Object data) {
        Result res = new Result();
        res.setData(data);
        res.setMsg(msg);
        res.setCode(code);
        res.setTotal(total);
        return res;
    }
}