import asia.lhweb.entity.Person;
import asia.lhweb.mapper.PersonMapper;
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
public class PersonTest {
    private SqlSession sqlSession;
    private PersonMapper personMapper;


    /**
     * 初始化
     */
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        //获取到sqlSession
        sqlSession= MybatisUtils.getSqlSession();
        //获取到monsterMapper对象
        personMapper= sqlSession.getMapper(PersonMapper.class);
        System.out.println("personMapper的类型："+personMapper);
    }
    @Test
    public void getPersonByid(){
        Person personByid = personMapper.getPersonByid(1);
        System.out.println(personByid);
    }
    @Test
    public void getPersonByid2(){
        Person personByid = personMapper.getPersonByid2(1);
        System.out.println(personByid);
    }
    public void showList(List list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
    public void showMap(List<Object> mapList ){
        for (Object o : mapList) {
            System.out.println("取出的mapList里的monster："+o);
        }
    }
    public void showMap2( List<Map<String, Object>> mapList ){
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
