package asia.lhweb.mapper;



import asia.lhweb.entity.Monster;
import org.apache.ibatis.annotations.Param;

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
     * 按年龄找到怪物
     * 请查询age大于10的所有妖怪，如果程序员输入的age不大于0,则输出所有的妖怪!
     *
     * @param age 年龄
     * @return {@link List}<{@link Monster}>
     */
    abstract List<Monster> findMonsterByAge(@Param(value = "agex")Integer age);//测试if

    /**
     * 需求:查询id大于20的，并且名字是"牛魔王”的所有妖怪,注意，如果名字为空，或者输入的id小于0,则不拼接sql语句
     * (如果名字为空则不带名字相关的条件)
     * （如果输入id<0就不带id条件）
     * @param monster
     * @return
     */
    abstract List<Monster> findMonsterByldAndName(Monster monster);//测试whre

    /**
     * 1)如果给的name不为空，就按名字查询妖怪，
     * 2)如果指定的id>0，就按id来查询妖怪
     * 3)如果前面两个条件都不满足,就默认查询salary > 100的
     * 4）要求使用choose/when/otherwise标签实现,传入参数要求使用Map
     * @param map
     * @return
     */
   abstract List<Monster> findMonsterByldAndName_choose(Map<String, Object> map);//测试choose标签

    /**
     * 查询id为1 8 9的妖怪
     * @param map
     * @return
     */
    abstract  List<Monster> findMonsterByld_forEach(Map<String, Object> map);//测试foreach标签

    /**
     * 找到怪物名字修剪
     * 按名字和年龄查询妖怪,如果sql语句开头有and | or就替换成where
     *
     * @param map 地图
     * @return {@link List}<{@link Monster}>
     */
    abstract List<Monster> findMonsterByName_Trim(Map<String,Object> map);//trim标签的使用

    /**
     * 请对指定id的妖怪进行修改，如果没有设置新的属性，则保持原来的值
     * @param map
     */
    abstract void updateMonster_set(Map<String, Object> map);//测试Set标签public


}
