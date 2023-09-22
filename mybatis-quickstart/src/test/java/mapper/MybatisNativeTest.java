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
 * @date : 2023/9/19
 */
public class MybatisNativeTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        //获取到sqlSession
        sqlSession= MybatisUtils.getSqlSession();
        System.out.println("sqlSession："+sqlSession.getClass());
    }
    @Test
    public void test1(){
        System.out.println("r1");
    }

    /**
     * 原生Api
     */
    @Test
    public void myBatisNative(){
        //增
        // Monster monster = new Monster();
        // monster.setAge(999);
        // monster.setBirthday(new Date());
        // monster.setEmail("lh@qq.com");
        // monster.setGender(1);
        // monster.setName("老鼠精"+1);
        // monster.setSalary(1000+9*10);
        // int insert = sqlSession.insert("asia.lhweb.mapper.MonsterMapper.addMonster", monster);
        // System.out.println("insert----"+insert);
        // System.out.println("添加成功");

        //删
        // int delete = sqlSession.delete("asia.lhweb.mapper.MonsterMapper.delMonster", 11);
        // System.out.println("delete----"+delete);

        //改
        // Monster monster2 = new Monster();
        // monster2.setId(10);
        // monster2.setAge(999);
        // monster2.setBirthday(new Date());
        // monster2.setEmail("lh@qq.com");
        // monster2.setGender(1);
        // monster2.setName("老鼠精"+1);
        // monster2.setSalary(1000+9*10);
        // int update = sqlSession.update("asia.lhweb.mapper.MonsterMapper.updateMonster", monster2);
        // System.out.println("update---"+update);

        //查
        List<Object> list = sqlSession.selectList("asia.lhweb.mapper.MonsterMapper.findAllMonster");
        System.out.println("monsterList---"+list);

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
