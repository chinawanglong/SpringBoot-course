package lesson15.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author elliot
 * @date 2020/08/05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("users")
public class User implements Serializable {
    private static final long serialVersionUID = 3304457287357148510L;

    private Long id;
    private String username;
    private String password;
}
