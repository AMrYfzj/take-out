package com.app.mapper;

import com.app.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应的套餐id
     *
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 批量插入套餐包含的菜品数据
     *
     * @param setmealDishes
     */

    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id查询该套餐所包含的菜品
     *
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long setmealId);

    /**
     * 根据套餐id批量删除套餐菜品的关联数据
     *
     * @param setmealIds
     */
    void deleteBatchBySetmealIds(List<Long> setmealIds);

    /**
     * 根据setmealId删除套餐菜品的关联数据
     *
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);
}
