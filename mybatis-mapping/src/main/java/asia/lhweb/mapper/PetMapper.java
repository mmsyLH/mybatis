package asia.lhweb.mapper;

import asia.lhweb.entity.Pet;

import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/22
 */
public interface PetMapper {


    /**
     * 通过User的id来获取pet对象，可能有多个，因此使用List接收
     * @param userld userld
     * @return {@link List}<{@link Pet}>
     */
    abstract List<Pet> getPetByUserld(Integer userld);


    /**
     * 通过pet的id获取Pet对象
     *
     * @param id id
     * @return {@link Pet}
     */
    abstract Pet getPetByld(Integer id);

}
