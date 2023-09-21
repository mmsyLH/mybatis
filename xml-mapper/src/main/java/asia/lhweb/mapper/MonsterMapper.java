package asia.lhweb.mapper;

import asia.lhweb.entity.Monster;

import java.util.List;
import java.util.Map;

/**
 * 怪物映射器
 *
 * @author 罗汉
 * @date 2023/09/14
 */

public interface MonsterMapper {

    /**
     * 通过id或名称找到怪物
     *
     * @param monster 怪物
     * @return {@link List}<{@link Monster}>
     */
     List<Monster> findMonsterByIdOrName(Monster monster);

    /**
     * 根据名字找到怪物(模糊查询)
     *
     * @param monster 怪物
     * @return {@link List}<{@link Monster}>
     */
     List<Monster> findMonsterByName(Monster monster);

    /**
     * 通过id和找到怪物
     * 查询id>10 并且salary大于40，要求传入的参数是HashMao
     *
     * @param map
     * @return {@link List}<{@link Monster}>
     */
    List<Monster> findMonsterByIdAnd(Map<String,Object>map);
    /**
     * 通过id和找到怪物
     * 查询id>10 并且salary大于40，要求传入的参数是HashMap 返回也是HashMap
     *
     * @param map
     * @return {@link List}<{@link Monster}>
     */
    List<Map<String,Object>>
    findMonsterByIdAndSalary_PrameterHashMap_ReturnHashMap(Map<String,Object>map);

}
