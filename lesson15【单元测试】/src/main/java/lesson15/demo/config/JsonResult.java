package lesson15.demo.config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 返回信息封装
 *
 * @author elliot
 * @param <T>
 */
@Data
@NoArgsConstructor
public class JsonResult<T> {

    private T data;
    private Integer code;
    private String msg;

//    public static


}
