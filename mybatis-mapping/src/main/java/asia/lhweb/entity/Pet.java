package asia.lhweb.entity;

import lombok.*;

/**
 * 宠物
 *
 * @author 罗汉
 * @date 2023/09/22
 */
// @Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    private Integer id;
    private String nickname;
    //一个pet对应一个User对象
    private User user;

}
