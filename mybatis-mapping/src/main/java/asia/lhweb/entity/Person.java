package asia.lhweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :罗汉
 * @date : 2023/9/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    //因为要实现查询的级联操作  一个人对应一个身份证
    private IdenCard card;
}
