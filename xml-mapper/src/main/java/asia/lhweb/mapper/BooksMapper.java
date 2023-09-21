package asia.lhweb.mapper;


import asia.lhweb.entity.Books;

import java.util.List;

/**
 * 用户映射器
 * 怪物映射器
 *
 * @author 罗汉
 * @date 2023/09/14
 */

public interface BooksMapper {

    void addBook(Books book);

    void delBookById(Integer id);

    Books getBookById(Integer id);


    void updateBook(Books book);


    List<Books> findAllBook();

}
