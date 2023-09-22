package asia.lhweb.mapper;

import asia.lhweb.entity.IdenCard;

/**
 * @author :罗汉
 * @date : 2023/9/22
 */
public interface IdenCardMapper {
    /**
     * 根据id获取到身份证序列化
     *
     * @param id id
     * @return {@link IdenCard}
     */
    abstract IdenCard getIdenCardByid(Integer id);

    /**
     * 根据id获取到身份证序列化
     * 返回的是级联信息
     * @param id id
     * @return {@link IdenCard}
     */
    abstract IdenCard getIdenCardByid2(Integer id);
}
