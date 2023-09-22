package mapper;

import asia.lhweb.entity.Monster;
import asia.lhweb.mapper.MonsterMapper;
import asia.lhweb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/15
 */
public class MonsterTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    /**
     * 初始化
     */
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        //获取到sqlSession
        sqlSession= MybatisUtils.getSqlSession();
        //获取到monsterMapper对象
        monsterMapper= sqlSession.getMapper(MonsterMapper.class);
        System.out.println("MonsterMapper的类型："+monsterMapper);
    }
    @Test
    public void addMonster(){
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(10+i);
            monster.setBirthday(new Date());
            monster.setEmail("lh@qq.com");
            monster.setGender(1);
            monster.setName("牛魔王"+i);
            monster.setSalary(1000+i*10);
            monsterMapper.addMonster(monster);
            System.out.println("添加到表中后的Id"+monster.getId());
        }
        //如果是增 删 改 需要提交事务
        res();
        System.out.println("ok");

    }

    /**
     * 删除怪物通过id
     */
    @Test
    public void delMonsterById(){
        monsterMapper.delMonster(7);
        res();
    }


    @Test
    public void updateMonster(){
        Monster monster = new Monster();
        monster.setId(7);
        monster.setAge(999);
        monster.setBirthday(new Date());
        monster.setEmail("lh@qq.com");
        monster.setGender(1);
        monster.setName("老鼠精"+1);
        monster.setSalary(1000+9*10);
        monsterMapper.updateMonster(monster);
        res();
    }


    @Test
    public void getMonsterById(){
        Monster monster = monsterMapper.getMonsterById(1);
        System.out.println(monster);
        res();
    }
    @Test
    public void findAllMonster(){
        List<Monster> allMonster = monsterMapper.findAllMonster2();
        for (Monster monster : allMonster) {
            System.out.println(monster);
        }
        res();
    }
    @Test
    public void res(){
        if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();//回归连接池
        }
    }


}
