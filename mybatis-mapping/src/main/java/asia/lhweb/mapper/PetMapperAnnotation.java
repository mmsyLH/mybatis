package asia.lhweb.mapper;

import asia.lhweb.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 通过注解方式完成级联多对一
 *
 * @author 罗汉
 * @date 2023/09/22
 */
public interface PetMapperAnnotation {
    @Select("select * from `mybatis_pet` where user_id=#{userId}")
    @Results(id = "PetResultMap",
            value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "user" ,
                    column = "user_id",
            one = @One(select = "asia.lhweb.mapper.UserMapperAnnotation.getUserByld"))

    })
    abstract List<Pet> getPetByUserId(Integer userId);
    @Select("select * from mybatis_pet where id=#{id}")
    @ResultMap("PetResultMap")
    abstract Pet getPetByld(Integer id);
}
