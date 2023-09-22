package asia.lhweb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 怪物
 *
 * @author 罗汉
 * @date 2023/09/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monster_cache {
    private Integer id;
    private Integer age;
    private String name;
    private String email;
    private Date birthday;
    private double salary;
    private Integer gender;
}