import asia.lhweb.entity.IdenCard;
import asia.lhweb.mapper.IdenCardMapper;
import asia.lhweb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author :罗汉
 * @date : 2023/9/15
 */
public class IdenCardMapperTest {
    private SqlSession sqlSession;
    private IdenCardMapper idenCardMapper;


    /**
     * 初始化
     */
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        //获取到sqlSession
        sqlSession= MybatisUtils.getSqlSession();
        //获取到monsterMapper对象
        idenCardMapper= sqlSession.getMapper(IdenCardMapper.class);
        System.out.println("idenCardMapper的类型："+idenCardMapper);
    }

    @Test
    public void getIdenCardByid(){
        IdenCard idenCardByid = idenCardMapper.getIdenCardByid(1);
        System.out.println(idenCardByid);
    }

    /**
     * 获得身份证由id2
     * 返回级联
     */
    @Test
    public void getIdenCardByid2(){
        IdenCard idenCardByid = idenCardMapper.getIdenCardByid2(1);
        System.out.println(idenCardByid);
    }
    @Test
    public void getPersonByid(){
        IdenCard idenCardByid = idenCardMapper.getIdenCardByid(1);
        System.out.println(idenCardByid);
    }

    @After
    public void res(){
        if (sqlSession!=null){
            sqlSession.commit();
            sqlSession.close();//回归连接池
        }
    }
}
