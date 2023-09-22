package asia.lhweb.mapper;

import asia.lhweb.entity.IdenCard;
import asia.lhweb.entity.Person;

/**
 * @author :罗汉
 * @date : 2023/9/22
 */
public interface PersonMapper {

    /**
     * 1对1级联方式有2种 这里演示第一种
     * 通过Person的id获取到Person,包括这个Person关联的IdenCard对象[级联查询]
     *
     * @param id id
     * @return {@link IdenCard}
     */
    abstract Person getPersonByid(Integer id);

    /**
     * 方式二 推荐
     *
     * @param id id
     * @return {@link Person}
     */
    abstract Person getPersonByid2(Integer id);

    /**
     * 通过card_id查询得到pserson对象
     *
     * @param cardId 卡id
     * @return {@link Person}
     */
    abstract Person getPersonByCardId(Integer cardId);
}
