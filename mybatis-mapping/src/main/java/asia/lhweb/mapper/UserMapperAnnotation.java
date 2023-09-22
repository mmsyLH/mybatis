package asia.lhweb.mapper;

import asia.lhweb.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author :罗汉
 * @date : 2023/9/22
 */
public interface UserMapperAnnotation {
    /**
     * 获取用户通过id
     *
     * @param id id
     * @return {@link User}
     */
    @Select("select * from mybatis_user where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(id = true,property = "name",column = "name"),
            //这里注意！ 对应返回pets属性对应的是集合
            @Result(property = "pets",column = "id",
                    many = @Many(select = "asia.lhweb.mapper.PetMapperAnnotation.getPetByUserId"))
    })
    abstract User getUserByld(Integer id);
}
