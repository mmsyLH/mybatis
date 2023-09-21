
import asia.lhweb.mapper.MonsterMapper;
import asia.lhweb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
    public void t1(){
        System.out.println("ok你好");
    }


    public void showList(List list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
    public void showMap( List<Map<String, Object>> mapList ){
        for (Map<String, Object> map : mapList) {
            System.out.println("取出的mapList里的map："+map);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                // System.out.println("取出的mapList："+entry);
            }
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
