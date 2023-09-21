package mapper;

import asia.lhweb.mapper.MonsterMapper;
import asia.lhweb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * 怪物注释测试
 *
 * @author 罗汉
 * @date 2023/09/19
 */
public class MonsterAnnotationTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        //获取到sqlSession
        sqlSession= MybatisUtils.getSqlSession();
        System.out.println("sqlSession："+sqlSession.getClass());
    }
    @Test
    public void res(){
        if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();//回归连接池
        }
    }
}
