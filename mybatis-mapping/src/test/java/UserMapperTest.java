import asia.lhweb.entity.Pet;
import asia.lhweb.entity.User;
import asia.lhweb.mapper.UserMapper;
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
public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;


    /**
     * 初始化
     */
    @Before//表示在执行你的目标测试方法前会先执行该方法
    public void  init(){
        sqlSession= MybatisUtils.getSqlSession();
        userMapper= sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void getUserByld(){
        User userByld = userMapper.getUserByld(1);
        showUser(userByld);
    }


    public void showUser(User user){
        System.out.println("用户ID："+user.getId());
        System.out.println("用户名："+user.getName());
        System.out.println("用户的宠物为：");
        List<Pet> pets = user.getPets();
        showPets(pets);
    }

    private void showPets(List<Pet> pets) {
        for (Pet pet : pets) {
            System.out.println("宠物名：" + pet.getNickname()+"宠物id：" + pet.getId()+"宠物的主人为："+pet.getUser().getName());
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
