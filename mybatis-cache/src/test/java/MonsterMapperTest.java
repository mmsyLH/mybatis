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
    @After
    public void res(){
        if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();//回归连接池
        }
    }


}
