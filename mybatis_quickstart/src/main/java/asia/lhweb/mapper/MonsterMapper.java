package asia.lhweb.mapper;

import asia.lhweb.entity.Monster;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 怪物映射器
 *
 * @author 罗汉
 * @date 2023/09/14
 */

public interface MonsterMapper {

    /**
     * 添加怪物
     *
     * @param monster 怪物
     */
    void addMonster(Monster monster);

    /**
     * 根据 id 删除一个 Monster
     *
     * @param id id
     */
    public void delMonster(Integer id);

    /**
     * 通过id获取怪物
     *
     * @param id id
     * @return {@link Monster}
     */
    @Select("select * from  monster where id=#{id}")
    Monster getMonsterById(String id);

    //修改 Monster
    void updateMonster(Monster monster);

    //查询所有的 Monster
    List<Monster> findAllMonster();
}
