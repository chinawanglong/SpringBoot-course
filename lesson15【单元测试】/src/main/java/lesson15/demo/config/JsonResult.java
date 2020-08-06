package lesson15.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * 返回信息封装
 *
 * @author elliot
 * @param <T>
 */
@Data
@NoArgsConstructor
public class JsonResult<T> implements Serializable {


    private static final long serialVersionUID = 4395212353478084519L;

    private int code;
    private String msg;
    private T data;

    private JsonResult(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private JsonResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 成功不带数据返回
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(){
        return new JsonResult<>(200,"操作成功");
    }

    /**
     * 成功带数据返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T data){
        return new JsonResult<>(200, "操作成功", data);
    }

    /**
     * 失败不带数据返回
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> fail(){
        return new JsonResult<>(0, "操作失败");
    }





}
