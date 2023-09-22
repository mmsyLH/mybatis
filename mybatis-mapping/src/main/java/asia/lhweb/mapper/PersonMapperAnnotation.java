package asia.lhweb.mapper;

import asia.lhweb.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author :罗汉
 * @date : 2023/9/22
 */
public interface PersonMapperAnnotation {
    @Select("select * from person where id=#{id}")
    //id 结果；标记出作为 ID 的结果可以帮助提高整体性能
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "card",column = "card_id",one = @One(select = "asia.lhweb.mapper.IdenCardMapper.getIdenCardByid")),
    })
    abstract Person getPersonByID(Integer id);
}
