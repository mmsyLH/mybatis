package asia.lhweb.mapper;

import asia.lhweb.entity.User;

/**
 * @author :罗汉
 * @date : 2023/9/22
 */
public interface UserMapper {
    /**
     * 通过id获取User对象
     *
     * @param id id
     * @return {@link User}
     */
    abstract User getUserByld(Integer id);

}
