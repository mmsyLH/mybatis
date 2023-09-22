package asia.lhweb.mapper;

import asia.lhweb.entity.IdenCard;
import org.apache.ibatis.annotations.Select;

/**
 * 使用注解方式实现1对1映射  对照xml的方式2
 * @author 罗汉
 * @date 2023/09/22
 */
public interface IdenCardMapperAnnotation {
    /**
     * 根据id获取到身份证序列化
     *
     * @param id id
     * @return {@link IdenCard}
     */
    @Select("select * from idencard where id=#{id}")
    abstract IdenCard getIdenCardByid(Integer id);
}
