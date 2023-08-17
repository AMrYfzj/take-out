package com.app.service;

import com.app.dto.SetmealDTO;
import com.app.dto.SetmealPageQueryDTO;
import com.app.entity.Setmeal;
import com.app.result.PageResult;
import com.app.vo.DishItemVO;
import com.app.vo.SetmealVO;

import java.util.List;

public interface SetmealService {

    /**
     * 新增套餐和其包含的菜品
     *
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /**
     * 套餐分页查询套餐分页查询
     *
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 批量删除套餐
     *
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询套餐及其包含的菜品
     *
     * @param id
     * @return
     */
    SetmealVO getByIdWithDish(Long id);

    /**
     * 修改套餐
     *
     * @param setmealDTO
     */
    void updateWithDish(SetmealDTO setmealDTO);

    /**
     * 起售停售套餐
     *
     * @param status
     * @param id
     */
    void status(Integer status, Long id);

    /**
     * 条件查询
     *
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     *
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);

}
