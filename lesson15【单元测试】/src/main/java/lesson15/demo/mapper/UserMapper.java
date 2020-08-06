package lesson15.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author elliot
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper {
}
