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
public class IdenCard {
    private Integer id;
    private String card_sn;
}
