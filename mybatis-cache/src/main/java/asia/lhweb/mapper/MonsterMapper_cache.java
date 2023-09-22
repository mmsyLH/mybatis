package asia.lhweb.mapper;


import asia.lhweb.entity.Monster_cache;

import java.util.List;

/**
 * 怪物映射器
 *
 * @author 罗汉
 * @date 2023/09/14
 */

public interface MonsterMapper_cache {
    Monster_cache getMonsterById(Integer id);

    //查询所有的 Monster
    List<Monster_cache> findAllMonster();
    // List<Monster> findMonsterByIdOrName(Monster monster);
}
