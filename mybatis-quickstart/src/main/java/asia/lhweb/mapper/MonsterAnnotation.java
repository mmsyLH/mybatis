package asia.lhweb.mapper;

import asia.lhweb.entity.Monster;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 怪物映射器
 *
 * @author 罗汉
 * @date 2023/09/14
 */

public interface MonsterAnnotation {

    /**
     * 添加怪物
     *
     * @param monster 怪物
     */
    @Insert("")
    /**
     * 拿到返回的Id
     * 1 useGeneratedKeys = true 返回自增的值
     * 2  keyProperty = "id" 自增对应的对象字段
     * 3  keyColumn = "id" 自增对应的表字段
     * 4 如果keyProperty和keyColumn一致可以不写keyColumn
     *
     */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addMonster(Monster monster);

    /**
     * 根据 id 删除一个 Monster
     *
     * @param id id
     */
    @Delete("")
    public void delMonster(Integer id);

    /**
     * 通过id获取怪物
     *
     * @param id id
     * @return {@link Monster}
     */
    @Select("select * from  monster where id=#{id}")
    Monster getMonsterById(String id);

    // 修改 Monster
    @Update("")
    void updateMonster(Monster monster);

    // 查询所有的 Monster
    @Select("")
    List<Monster> findAllMonster();
}
