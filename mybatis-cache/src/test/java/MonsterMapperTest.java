import asia.lhweb.entity.Monster_cache;
import asia.lhweb.mapper.MonsterMapper_cache;
import asia.lhweb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/15
 */
public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper_cache monsterMapper_cache;

    /**
     * 初始化
     */
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        sqlSession= MybatisUtils.getSqlSession();
        monsterMapper_cache= sqlSession.getMapper(MonsterMapper_cache.class);
    }
    @Test
    public void test(){
        System.out.println("hello");
    }

    @Test
    public void getMonsterById(){
        Monster_cache monsterById = monsterMapper_cache.getMonsterById(1);
        System.out.println(monsterById);

    }
    @Test
    public void findAllMonster(){
        List<Monster_cache> allMonster = monsterMapper_cache.findAllMonster();
        for (Monster_cache monster : allMonster) {
            System.out.println(monster);
        }

    }

    /**
     * 测试一级缓存 默认开启 跟sqlSession有关
     */
    @Test
    public void test1(){
        Monster_cache monsterById = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById:"+monsterById);

        Monster_cache monsterById2 = monsterMapper_cache.getMonsterById(6);
        System.out.println("monsterById2:"+monsterById2);

        System.out.println("因为一级缓存默认是打开的，当你再次查询相同的id时，不会再发出sql语句");
        Monster_cache monsterById3 = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById3:"+monsterById3);
    }

    /**
     * 测试一级缓存失效 第一种情况
     * 当关闭sqlsession时 一级缓存失效
     */
    @Test
    public void test2(){
        Monster_cache monsterById = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById:"+monsterById);

        if (sqlSession!=null){
            sqlSession.close();//回归连接池
        }
        sqlSession= MybatisUtils.getSqlSession();
        monsterMapper_cache= sqlSession.getMapper(MonsterMapper_cache.class);

        System.out.println("因为一级缓存默认是打开的，你关闭后，当你再次查询相同的id时，会再发出sql语句");
        Monster_cache monsterById3 = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById3:"+monsterById3);
    }
    /**
     * 测试一级缓存失效 第二种情况
     * 当执行sqlsession.clearCache()时 一级缓存失效
     */
    @Test
    public void test3(){
        Monster_cache monsterById = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById:"+monsterById);

        if (sqlSession!=null){
            sqlSession.clearCache();
        }
        System.out.println("因为一级缓存默认是打开的，你关闭后，当你再次查询相同的id时，会再发出sql语句");
        Monster_cache monsterById3 = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById3:"+monsterById3);
    }
    /**
     * 测试一级缓存失效 第三种情况
     * 修改了同一个monster对象时 一级缓存失效
     */
    @Test
    public void test4(){
        Monster_cache monsterById = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById:"+monsterById);

        monsterById.setName("粟炜精");

        monsterMapper_cache.updateMonster(monsterById);

        System.out.println("因为你修改了对象，导致缓存失效，当你再次查询相同的id时，会再发出sql语句");
        Monster_cache monsterById3 = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById3:"+monsterById3);
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void test5(){
        Monster_cache monsterById = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById:"+monsterById);

        if (sqlSession!=null){
            sqlSession.close();//回归连接池
        }
        sqlSession= MybatisUtils.getSqlSession();
        monsterMapper_cache= sqlSession.getMapper(MonsterMapper_cache.class);

        System.out.println("因为你配置二级缓存，关闭了sqlsession，当你再次查询相同的id时，不会再发出sql语句");
        Monster_cache monsterById3 = monsterMapper_cache.getMonsterById(1);
        System.out.println("monsterById3:"+monsterById3);
    }
    @After
    public void res(){
        if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();//回归连接池
        }
    }


}
