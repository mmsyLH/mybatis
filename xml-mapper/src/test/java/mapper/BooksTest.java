package mapper;

import asia.lhweb.entity.Books;
import asia.lhweb.mapper.BooksMapper;
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
public class BooksTest {
    private SqlSession sqlSession;
    private BooksMapper booksMapper;

    /**
     * 初始化
     */
    @Before// 表示在执行你的目标测试方法前会先执行该方法
    public void init() {
        // 获取到sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        // 获取到monsterMapper对象
        booksMapper = sqlSession.getMapper(BooksMapper.class);
        System.out.println("usersMapper的类型：" + booksMapper);
    }

    @Test
    public void addBook() {
        Books books = new Books();
        books.setBookName("j2ee");
        books.setAuthor("韩顺平");
        books.setPublisher("it韩顺平");
        booksMapper.addBook(books);
        System.out.println("添加成功，添加的book为"+books);
    }


    @Test
    public void delBookById() {
        booksMapper.delBookById(6);
        System.out.println("删除Book成功");
    }

    @Test
    public void getBookById() {
        Books book = booksMapper.getBookById(5);
        System.out.println("获取的Book："+book);
    }

    @Test
    public void updateBook() {
        Books books = new Books();
        books.setBookId(5);
        books.setBookName("j2ee第二版");
        books.setAuthor("黑马程序员");
        books.setPublisher("ItHeima");
        booksMapper.updateBook(books);
    }

    @Test
    public void findAllBook() {
        List<Books> allBook = booksMapper.findAllBook();
        for (Books books : allBook) {
            System.out.println("查询到的boos为："+books);
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